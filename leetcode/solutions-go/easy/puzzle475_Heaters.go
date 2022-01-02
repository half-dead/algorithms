/*
https://leetcode.com/problems/heaters/description/

Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.

Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.

So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.

Note:
    Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
    Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
    As long as a house is in the heaters' warm radius range, it can be warmed.
    All the heaters follow your radius standard and the warm radius will the same.
Example 1:
    Input: [1,2,3],[2]
    Output: 1
    Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
Example 2:
    Input: [1,2,3,4],[1,4]
    Output: 1
    Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.

*/

package main

import (
  "fmt"
  "math"
  "sort"
)

func main() {
  fmt.Println(findRadius([]int{1, 2, 3, 4}, []int{1, 4}))
}

func dist(a, b int) int {
  if d := a - b; d < 0 {
    return -d
  } else {
    return d
  }
}

func findRadius(houses []int, heaters []int) int {

  sort.Ints(houses)
  sort.Ints(heaters)

  housesLen := len(houses)
  heatersLen := len(heaters)

  heaterIndex, radius := 0, 0
  for i := 0; i < housesLen; i++ {
    house := houses[i]
    for heaterIndex < heatersLen-1 && dist(house, heaters[heaterIndex]) >= dist(house, heaters[heaterIndex+1]) {
      heaterIndex++
    }

    if curDist := dist(house, heaters[heaterIndex]); curDist > radius {
      radius = curDist
    }
  }

  return radius
}

type p475_TooFuckingSlowSolution int

func (p475_TooFuckingSlowSolution) findRadius(houses []int, heaters []int) int {

  sort.Ints(houses)
  sort.Ints(heaters)

  housesLen := len(houses)
  heatersLen := len(heaters)
  radius := int(math.Min(math.Abs(float64(heaters[0]-houses[0])), math.Abs(float64(heaters[heatersLen-1]-houses[housesLen-1]))))

  for len(houses) > 0 {
    heaterIndex := 0
    temp := make([]int, 0)
    for i := 0; i < len(houses); i++ {
      house := houses[i]

      found := false
      j := heaterIndex
      for ; j < heatersLen; j++ {
        min, max := heaters[j]-radius, heaters[j]+radius
        if house >= min && house <= max {
          found = true
          break
        }
      }
      if !found {
        heaterIndex = j - 1
        temp = append(temp, house)
      }
    }

    if len(temp) > 0 {
      firstUncovered := temp[0]
      newRadius := math.MaxInt32
      for _, heater := range heaters {
        dis := 0
        if heater > firstUncovered {
          dis = heater - firstUncovered
        } else {
          dis = firstUncovered - heater
        }
        if dis < newRadius {
          newRadius = dis
        }
      }
      radius = newRadius
    }

    houses = temp
  }
  return radius
}
