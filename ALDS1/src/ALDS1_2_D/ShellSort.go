package main

import (
  "bufio"
  "fmt"
  "os"
  "strconv"
)

var count int = 0

func main () {
  fmt.Print("Input : ")
  sc := bufio.NewScanner(os.Stdin)

  var m int = 0
  var G []int

  // Get "length"
  var length int
  if sc.Scan() { length, _ = strconv.Atoi(sc.Text()) }

  // Set "m"
  for i := 1; ; i = 3*i + 1{
    if i > length { break }
    G = append(G, i)
    m++
  }

  // Get input array
  input := make([]int, length)
  for i := 0; i < length; i++ {
    if sc.Scan() { input[i], _ = strconv.Atoi(sc.Text()) }
  }

  for i := m; i > 0; i-- {
    input = insertionSort(input, length, G[i-1])
  }

  // Print
  fmt.Println("Output : ")
  fmt.Printf("%d\n", m)
  for i := m-1; i > 0; i-- {
    fmt.Printf("%d ",G[i])
  }
  fmt.Printf("%d\n", G[0])
  fmt.Printf("%d\n", count)
  for i := 0; i < length; i++ {
    fmt.Printf("%d\n", input[i])
  }
}

func insertionSort(input []int, length, gap int) []int{
  var v, j int
  for i := gap; i < length; i++ {
    v = input[i]
    j = i - gap
    for ;j >= 0 && input[j] > v; {
      input[j + gap] = input[j]
      j = j-gap
      count++
    }
    input[j+gap] = v
  }

  return input
}
