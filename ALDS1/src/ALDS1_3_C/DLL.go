package main
import (
    "bufio"
    "fmt"
    "os"
    "strconv"
)

var i int = 0       // current index
var tail int = 0    // ahead index

func main() {
    sc := bufio.NewScanner(os.Stdin)
    sc.Split(bufio.ScanWords)

    // number of data
    var n int
    if sc.Scan() { n, _ = strconv.Atoi(sc.Text()) }

    // prepare the array
    var array []int = make([]int, n, n)

    // run
    var c string    // command
    var x int       // number
    for ; sc.Scan();  {
        c = sc.Text()

        switch c {
          // 各演算子を受け取ったらスタックの値を用いて演算を実行
        case "insert":
            if sc.Scan() { x, _ = strconv.Atoi(sc.Text()) }
            array = insert(array, x)
        case "delete":
            if sc.Scan() { x, _ = strconv.Atoi(sc.Text()) }
            array = delete(array, x)
        case "deleteFirst":
            deleteFirst(array)
        case "deleteLast":
            deleteLast(array)
        }
    }
    for a := i-1; a >= tail+1; a-- {
        if array[a] != -1 {
            fmt.Printf("%d ", array[a])
        }
    }
    fmt.Printf("%d\n", array[tail])
}

func insert(array []int, x int) []int{
    array[i] = x
    i++
    return array
}

func delete(array []int, x int) []int{
    for k := i-1; k >= tail; k--{
        if array[k] == x {
            array[k] = -1
            if k == tail { tail++ }
            break
        }
    }
    return array
}

func deleteFirst(array []int) {
    i--
    if array[i] == -1 { deleteFirst(array) }
}

func deleteLast(array []int) {
    tail++
    if array[tail] == -1 { deleteLast(array) }
}
