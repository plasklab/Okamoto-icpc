package main

import (
  "bufio"
  "fmt"
  "os"
  "strconv"
)

const {
    var fs int
    var ls int
}

func main() { () {
    fmt.Print("Input : ")
    sc := bufio.NewScanner(os.Stdin)

    if sc.Scan() { in = sc.Text() }
    var i int = 0
    var ns int = 0
    for ; ; {
        for ; i < len(in) ; i++ {
            if in[i] == '\' { break }
        }
        for ; i < len(in) ; i++ {
            switch in[i] {
            case '/':
                ns--
            case '\':
                ns++
            default:

            }
            if ns == 0 {  }
        }
    }
}
