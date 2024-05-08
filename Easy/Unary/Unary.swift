import Glibc
import Foundation

public struct StderrOutputStream: TextOutputStream {
    public mutating func write(_ string: String) { fputs(string, stderr) }
}
public var errStream = StderrOutputStream()

let MESSAGE = readLine()!

let mchars = MESSAGE.cString(using: String.Encoding.ascii)!
var strbin : String = ""
for i in 0..<(mchars.count-1) {
    let c = mchars[i]
    for j in (0...6).reversed() {
        strbin += String((c >> j) & 1)
    }
}

let bchars = strbin.cString(using: String.Encoding.ascii)!
var struna : String = ""

var prev : CChar = CChar(bitPattern: 0b0)
var count = 0
for i in 0..<(bchars.count-1) {
    let c = bchars[i]
    if c != prev {
        if count != 0 {
            struna += " "
        }
        if c == 48 {
            struna += "00 0"
        } else {
            struna += "0 0"
        }
        count = 1
        prev = c
    } else {
        struna += "0"
        count += 1
    }
}
print(struna)
