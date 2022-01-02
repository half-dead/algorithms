// https://leetcode.com/problems/reformat-date/

package main

import (
  "fmt"
  "regexp"
  "strings"
)

var months = [13]string{"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}
var monthsMap map[string]string

func init() {
  monthsMap = make(map[string]string, 13)
  for i, m := range months {
    monthsMap[m] = fmt.Sprintf("%02d", i)
  }
}

func reformatDate(date string) string {
  arr := strings.Split(date, " ")
  day := regexp.MustCompile("[a-z]").ReplaceAllString(arr[0], "")
  month := monthsMap[arr[1]]
  return fmt.Sprintf("%s-%s-%02s", arr[2], month, day)
}

func main() {
  fmt.Println(reformatDate("20th Oct 2052"))
  fmt.Println(reformatDate("6th Jun 1933"))
  fmt.Println(reformatDate("26th May 1960"))
}
