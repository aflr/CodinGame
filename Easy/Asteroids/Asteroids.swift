import Glibc
import Foundation

public struct StderrOutputStream: TextOutputStream {
    public mutating func write(_ string: String) { fputs(string, stderr) }
}
public var errStream = StderrOutputStream()

let empty : Character = "."

let inputs = (readLine()!).split(separator: " ").map(String.init)
let W = Int(inputs[0])!
let H = Int(inputs[1])!
let T1 = Int(inputs[2])!
let T2 = Int(inputs[3])!
let T3 = Int(inputs[4])!

// Calculate time difference
let TD : Double = Double(T3 - T2) / Double(T2 - T1)

// Declare matrices p1, p2, p3
var pictureT1 : [[Character]] = []
var pictureT2 : [[Character]] = []
var pictureT3 = Array(repeating: Array(repeating: empty, count: W), count: H)

var maxChar : Character = "A"

// Read input, store in 'pictureT1', 'pictureT2'
if H > 0 {
    for i in 0...(H-1) {
        let inputs = (readLine()!).split(separator: " ").map(String.init)
        let firstPictureRow = Array(inputs[0])
        let secondPictureRow = Array(inputs[1])

        pictureT1.append(firstPictureRow)
        pictureT2.append(secondPictureRow)

        // Find char with max value
        for c in firstPictureRow {
            if c != "." && c > maxChar {
                maxChar = c
            }
        }
    }
}

// Solve
for cUnicode in (("A".unicodeScalars.first!.value)...(maxChar.unicodeScalars.first!.value)).reversed() {
    let c = Character(Unicode.Scalar(cUnicode)!)
    var x1 = -1, x2 = -1, y1 = -1, y2 = -1
    search: for i in 0...(H-1) {
        for j in 0...(W-1) {
            if (pictureT1[i][j] == c) {
                x1 = j
                y1 = i
            }
            if (pictureT2[i][j] == c) {
                x2 = j
                y2 = i
            }
            if x1 != -1 && x2 != -1 {
                break search
            }
        }
    }
    if (x1 == -1 || x2 == -1) {
        continue
    }
    // Calculate new position (X3, Y3)
    var x3 = Int(floor(Double(x2) + Double(x2 - x1) * TD))
    var y3 = Int(floor(Double(y2) + Double(y2 - y1) * TD))
    // If position is inside picture, set it
    if (x3 >= 0 && x3 < W && y3 >= 0 && y3 < H) {
        pictureT3[y3][x3] = c
    }
}

// Print solution
for row in pictureT3 {
    for c in row {
        print(c, separator: "", terminator: "")
    }
    print()
}
