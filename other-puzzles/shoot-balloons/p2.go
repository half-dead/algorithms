package main

import (
  "bufio"
  "fmt"
  "math"
  "os"
  "strconv"
  "strings"
)

type point struct {
  x, y, z float64
}

type vector struct {
  dx, dy, dz float64
}

type ray struct {
  origin    point
  direction vector
}

type sphere struct {
  center point
  radius float64
}

var reader = bufio.NewReader(os.Stdin)

func main() {
  for ; ; {
    numBalloons, _ := strconv.Atoi(readLine())
    if numBalloons == 0 {
      break
    }

    balloons := make(map[int]sphere)
    for i := 0; i < numBalloons; i++ {
      balloons[i] = newBalloon(readLine())
    }

    numGunshots, _ := strconv.Atoi(readLine())
    for i := 0; i < numGunshots; i++ {
      gunshot := newGunshot(readLine())
      popped := make([]int, 0, len(balloons))
      for key, b := range balloons {
        if hit(gunshot, b) {
          popped = append(popped, key)
        }
      }
      fmt.Println(len(popped))

      for _, key := range popped {
        delete(balloons, key)
      }
    }
  }
}

func readLine() string {
  res, _, _ := reader.ReadLine()
  return string(res)
}

// radius, string length, x, y
func newBalloon(s string) sphere {
  arr := strings.Split(s, " ")
  radius := asFloat64(arr[0])
  return sphere{
    point{asFloat64(arr[2]), asFloat64(arr[3]), asFloat64(arr[1]) + radius},
    radius,
  }
}

func newGunshot(s string) ray {
  arr := strings.Split(s, " ")
  return ray{
    point{asFloat64(arr[0]), asFloat64(arr[1]), asFloat64(arr[2])},
    vector{asFloat64(arr[3]), asFloat64(arr[4]), asFloat64(arr[5])},
  }
}

func asFloat64(s string) float64 {
  res, _ := strconv.ParseFloat(s, 64)
  return res
}

func hit(gunshot ray, balloon sphere) bool {
  origin, center := gunshot.origin, balloon.center
  oc := vector{origin.x - center.x, origin.y - center.y, origin.z - center.z}

  a := dotProduct(gunshot.direction, gunshot.direction)
  b := dotProduct(gunshot.direction, oc) * 2.0
  c := dotProduct(oc, oc) - (balloon.radius * balloon.radius)

  discriminant := b*b - a*c*4.0

  if discriminant < 0 {
    return false
  }
  return -b+math.Sqrt(discriminant) > 0
}

func dotProduct(v1, v2 vector) float64 {
  return v1.dx*v2.dx + v1.dy*v2.dy + v1.dz*v2.dz
}
