import Glibc
import Foundation

public struct StderrOutputStream: TextOutputStream {
    public mutating func write(_ string: String) { fputs(string, stderr) }
}
public var errStream = StderrOutputStream()

let inputs = (readLine()!).split(separator: " ").map(String.init)
let height = Int(inputs[0])!
let width = Int(inputs[1])!

var nums : [[Int]] = Array(repeating: Array(repeating: 0, count: width), count: height)
var XS : [[Bool]] = Array(repeating: Array(repeating: false, count: width), count: height)

for i in 0..<height {
    let line : [String] = readLine()!.split(separator: " ").map {String($0)}
    for j in 0..<line.count {
        nums[i][j] = Int(line[j])!
    }
}

for i in 0..<height {
    let line : [String] = readLine()!.split(separator: " ").map {String($0)}
    for j in 0..<line.count {
        XS[i][j] = line[j] == "X"
    }
}

var prevSign : Int = 0
for i in 0..<height {
    for j in 0..<width {
        if !XS[i][j] {
            continue;
        }
        let sign : Int = {
            switch nums[i][j] {
                case let x where x < 0: return -1
                case let x where x > 0: return 1
                default: return 0
            }
        }()
        if prevSign == sign {
            print(false)
            exit(0)
        }
        prevSign = sign
    }
}
print(true)
