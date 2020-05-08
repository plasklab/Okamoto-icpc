package main
import (
    "bufio"
    "fmt"
    "os"
    "strconv"
)

func main () {
    sc := bufio.NewScanner(os.Stdin)
    sc.Split(bufio.ScanWords)

    fmt.Println("Input : ")
    // Get input "n" and "q"
    var n int
    var q int
    if sc.Scan() { n, _ = strconv.Atoi(sc.Text()) }
    if sc.Scan() { q, _ = strconv.Atoi(sc.Text()) }

    // Get input array
    var inName []string
    var inTime []int
    inName = make([]string, n)
    inTime = make([]int, n)
    for i := 0; i < n; i++ {
        if sc.Scan() { inName[i] = sc.Text() }
        if sc.Scan() { inTime[i], _ = strconv.Atoi(sc.Text()) }
    }

    // Preparation
    var progress int = 0    // the number of finished process each loop
    var fin int = 0         // the total number of finished process
    var isFirst bool = true
    var total int = 0

    // Carry out
    fmt.Println("Output : ")
    for {
        for i := 0; i < n - fin; i++ {
            inTime[i] -= q

            // まずは一つ、終了するプロセスが見つかるまで走査
            if inTime[i] < 1 && isFirst {
                isFirst = false
                total += q + inTime[i]
                progress++
                fmt.Printf("%s %d\n", inName[i], total)
                continue
            } else if inTime[i] > 0 && isFirst {
                total += q
            }

            //
            if inTime[i] > 0 && !isFirst {
                total += q
                inTime[i], inTime[i-progress] = inTime[i-progress], inTime[i]
                inName[i], inName[i-progress] = inName[i-progress], inName[i]
            } else if inTime[i] < 1 && !isFirst {
                total += q + inTime[i]
                fmt.Printf("%s %d\n", inName[i], total)
                progress++
            }
        }
        isFirst = true
        fin += progress
        progress = 0
        if n == fin { break }
    }
}
