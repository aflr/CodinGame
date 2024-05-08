import Glibc
import Foundation

public struct StderrOutputStream: TextOutputStream {
    public mutating func write(_ string: String) { fputs(string, stderr) }
}
public var errStream = StderrOutputStream()

let N = Int(readLine()!)!
var ps : [Int] = Array()
for i in 0..<N {
    ps.append(Int(readLine()!)!)
}
ps.sort()
var small = Int.max
for i in 0..<(ps.count-1) {
    small = min(small, abs(ps[i] - ps[i + 1]))
}
print(small)
