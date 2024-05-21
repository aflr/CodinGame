import Foundation
let N = Int(readLine()!)!
let inputs = (readLine()!).split(separator: " ").map(String.init)
let A = Int(inputs[0])!
let B = Int(inputs[1])!
var s = String(repeating: String(A), count: A)
var i = 1
while s.count < N {
    let cStr = s.cString(using: String.Encoding.ascii)!
    s.append(String(repeating: String(B), count: i < cStr.count - 1 ? Int(cStr[i] - 48) : B))
    s.append(String(repeating: String(A), count: Int(s.cString(using: String.Encoding.ascii)![i + 1]) - 48))
    i += 2
}
print(s.prefix(N))
