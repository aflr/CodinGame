import Foundation
let N = Int(readLine()!)!
let a = Int(readLine()!)!
var res : [Set<Int>] = []
res.append([a])
for i in 1...12 {
    if res.count < i {
        var set : Set<Int> = []
        for j in 1..<i {
            res[j - 1].forEach { n1 in
                res[i - j - 1].forEach { n2 in
                    set.insert(n1 + n2)
                    set.insert(abs(n1 - n2))
                    set.insert(n1 * n2)
                    if n2 != 0 && n1 % n2 == 0 {
                        set.insert(n1 / n2)
                    }
                }
            }
        }
        res.append(set)
    }
    if res[i - 1].contains(N) {
        print(i)
        exit(0)
    }
}
