package test;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * "prove of concept"
 * We are going to create a POC web service that will handle personalized content recommendations.
 * Given a Container, which contains items (a Sequence of Integers), your service re-orders those items according to a Ranking.
 * <p>
 * case class Container(userId: String, items: Seq[Int])
 * case class Ranking(userId: String, criteria: Seq[Int]) {
 * def rank(c: Container): Container = ???
 * }
 * Calling rank() on a Container should return a Container with the same items as the input
 * but in an order consistent with the Ranking data.
 * <p>
 * Another team will be responsible for generating the Rankings,
 * there will be an interface TBD between their service that generates Rankings and your system that uses Rankings.
 * <p>
 * You may code this up using whatever frameworks/libraries you feel most comfortable with.
 * We are a Scala shop (we like Akka Streams), so Scala would be best, but you may code in Java if you are very new to Scala.
 */
public class TubiTVSession2 {

    //val ranking = Ranking("poc", List(1, 2, 3))
    //val container = Container("poc", List(0, 3, 4))


    //trait RankingService{
    //  def handleRequest(c: Container): Future[Container] = ???
    //}

    public int hash(String userId){return 0;}

    public static void main(String[] args) throws InterruptedException {

        RankingRepo repo = userId -> new Ranking(userId, Arrays.asList(1, 2, 3));
        RankingServiceImpl rs = new RankingServiceImpl(repo);

        List<Container> containers = Arrays.asList(
                new Container("poc", Arrays.asList(0, 3, 4)),
                new Container("poc", Arrays.asList(1, 6, 3, 9, 2, 4))
        );

        containers.forEach(c -> rs.handleRequest(c).thenAccept(System.out::println));

        rs.shutdown(1, TimeUnit.SECONDS);
    }
}

interface RankingService {
    CompletableFuture<Container> handleRequest(Container c);
}

interface RankingRepo {
    Ranking query(String userId);
}

class RankingServiceImpl implements RankingService {

    RankingRepo repo;
    ExecutorService ioThreads, computeThreads;

    public RankingServiceImpl(RankingRepo repo) {
        this.repo = repo;
        ioThreads = Executors.newCachedThreadPool();
        computeThreads = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    @Override
    public CompletableFuture<Container> handleRequest(Container c) {
        return CompletableFuture.supplyAsync(() -> repo.query(c.userId), ioThreads)
                .thenApplyAsync(r -> r.rank(c), computeThreads);
    }

    void shutdown(long timeout, TimeUnit unit) throws InterruptedException {
        ioThreads.shutdown();
        ioThreads.awaitTermination(timeout, unit);
        computeThreads.shutdown();
        computeThreads.awaitTermination(timeout, unit);
    }
}

class Container {
    String userId;
    List<Integer> items;

    public Container(String usreId, List<Integer> items) {
        this.userId = usreId;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Container{" +
                "userId='" + userId + '\'' +
                ", items=" + items +
                '}';
    }
}

class Ranking {
    private final String userId;
    private final Map<Integer, Integer> map;
    private final Comparator<Integer> rankingComparator;

    public Ranking(String userId, List<Integer> criteria) {
        this.userId = userId;

        map = IntStream.range(0, criteria.size()).boxed()
                .collect(Collectors.toMap(criteria::get, Function.identity()));
        rankingComparator = Comparator.comparingInt(a -> map.getOrDefault(a, Integer.MAX_VALUE));
    }

    Container rank(Container c) {
        if (!c.userId.equals(userId)) {
            return c;
        }

        return new Container(c.userId, c.items.stream().sorted(rankingComparator).collect(Collectors.toList()));
    }
}
