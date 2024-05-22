import Foundation

func faro(_ t : Int, _ a : [Int]) -> [Int] {
    if t == 0 { return a }
    var na = Array(repeating: 0, count: L)
    for i in 0..<L { na[(2 * i + 2 * i / (L + L % 2)) % (L + L % 2)] = a[i] }
    return faro(t - 1, na)
}

let n = Int(readLine()!)!
let deck = readLine()!.split(separator: " ")
let L = deck.count
let idxs = faro(n, Array(0..<L))

var res = ""
idxs.forEach { res += " \(deck[$0])"}
print(res.substring(from: 1))
