import Glibc
import Foundation

public struct StderrOutputStream: TextOutputStream {
    public mutating func write(_ string: String) { fputs(string, stderr) }
}
public var errStream = StderrOutputStream()

while true {
    let enemy1 = readLine()!
    let dist1 = Int(readLine()!)!
    let enemy2 = readLine()!
    let dist2 = Int(readLine()!)!

    if (dist1 < dist2)
    {
        print(enemy1)
    }
    else
    {
        print(enemy2)      
    }
}
