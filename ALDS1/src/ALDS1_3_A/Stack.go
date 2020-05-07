package main

import (
  "bufio"
  "fmt"
  "os"
)

var stack [100]int
var sp int = 0

func main() {
  fmt.Println("Input : ")
  sc := bufio.NewScanner(os.Stdin)

  var input string
  if sc.Scan() {
    input = sc.Text()
  }

  fmt.Printf("Input length : %d\n", len(input))
  //  1文字ずつ操作しながらそれぞれの処理を行う
  var op bool = false
  var digits int8 = 0
  var buf int
  for _, r := range input {
    switch r {
      // 各演算子を受け取ったらスタックの値を用いて演算を実行
    case '+':
      op = true
      // debug
      fmt.Printf("get + operation; %d + %d\n%v\n", stack[sp-2], stack[sp-1], stack)
      stack[sp-2] += stack[sp-1]
      sp--
    case '-':
      op = true
      // debug
      fmt.Printf("get - operation; %d - %d\n%v\n", stack[sp-2], stack[sp-1], stack)
      stack[sp-2] -= stack[sp-1]
      sp--
    case '*':
      op = true
      // debug
      fmt.Printf("get * operation; %d * %d\n%v\n", stack[sp-2], stack[sp-1], stack)
      stack[sp-2] *= stack[sp-1]
      sp--
    case ' ':
      //　空白を受け取ったら次へ行く
      if !op {
        stack[sp] = buf
        sp++
        fmt.Printf("Push : %d\n", buf)
        buf = 0
      }
      op = false
      digits = 0
    default:
      // 数値を受け取る。
      buf = buf*10 + int(r - '0')
      digits++
    }
  }

  fmt.Printf("%d", stack[0])
}
