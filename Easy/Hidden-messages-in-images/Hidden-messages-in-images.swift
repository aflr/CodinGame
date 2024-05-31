import Foundation

let inputs = readLine()!.split(separator: " ").map{Int($0)!}
let w = inputs[0], h = inputs[1]
var bytes = Array(repeating: String(""), count: (w * h) >> 3)
for i in 0..<h {
    for (j, n) in readLine()!.split(separator: " ").map{Int($0)!}.enumerated() {
        bytes[(i * w + j) >> 3].append(String(n & 1))
    }
}
print(String(bytes: bytes.map{UInt8($0, radix: 2)!}, encoding: String.Encoding.ascii)!)
