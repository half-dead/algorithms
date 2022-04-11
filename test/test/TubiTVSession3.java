package test;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Given the following:
 * <p>
 * sealed trait HttpRequest {
 * def xForwardedFor: Option[String]
 * }
 * <p>
 * abstract class RateLimiter(limitPerSecond: Int) {
 * def shouldLimit(req: HttpRequest): Boolean
 * }
 * <p>
 * Implement a rate limiter, which accepts an http request, and decides whether we should apply rate limit on it.
 */
public class TubiTVSession3 {
    public static void main(String[] args) {
        HttpRequest[] reqs = new HttpRequest[]{
                new HttpRequest(null),
//                new HttpRequest("1.1.1.1"),
//                new HttpRequest("2.2.2.2")
        };
        RateLimiterImpl rli = new RateLimiterImpl(2);
        IntStream.range(0, 100).forEach(i -> {
            HttpRequest req = reqs[i % reqs.length];
            System.out.print("index=" + i + ", " + req + " ");
            System.out.print(rli.shouldLimit(req) + " ");
            System.out.println(rli.shouldLimit(req));
            try {
                TimeUnit.MILLISECONDS.sleep(900);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

}

class HttpRequest {

    String ip;

    public HttpRequest(String ip) {
        this.ip = ip;
    }

    Optional<String> xForwardedFor() {
        return Optional.ofNullable(ip);
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "ip='" + ip + '\'' +
                '}';
    }
}

abstract class RateLimiter {

    int limit;

    RateLimiter(int limitPerSecond) {
        this.limit = limitPerSecond;
    }

    abstract boolean shouldLimit(HttpRequest req);

}

class RateLimiterImpl extends RateLimiter {

    ConcurrentHashMap<String, LimitHolder> map;

    RateLimiterImpl(int limitPerSecond) {
        super(limitPerSecond);
        map = new ConcurrentHashMap<>();
    }

    @Override
    boolean shouldLimit(HttpRequest req) {
        String key = req.xForwardedFor().orElse("");
        LimitHolder holder = map.computeIfAbsent(key, k -> new LimitHolder(super.limit));
        return !holder.check();
    }
}

class LimitHolder {
    int cnt = 0;
    final int limit;
    final long[] records;

    public LimitHolder(int limit) {
        this.limit = limit;
        records = new long[limit];
    }

    synchronized boolean check() {
        long time = System.currentTimeMillis();
        if (cnt < limit) {
            records[cnt++] = time;
            return true;
        }

        int index = cnt % limit;
        if (time - records[index] < 1000) return false;

        records[index] = time;
        cnt++;
        return true;
    }
}
