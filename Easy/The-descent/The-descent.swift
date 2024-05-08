import Glibc
import Foundation

public struct StderrOutputStream: TextOutputStream {
    public mutating func write(_ string: String) { fputs(string, stderr) }
}
public var errStream = StderrOutputStream()

while true {
    var localMax = Int.min
    var index = 0
    for i in 0...7 {
        let h = Int(readLine()!)!
        index = h > localMax ? i : index
        localMax = max(localMax, h)
    }
    print(index)
}
