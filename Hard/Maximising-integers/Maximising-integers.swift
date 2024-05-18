import Foundation

let N : [CChar] = readLine()!.cString(using: String.Encoding.ascii)!
var evens : [CChar] = []
var odds : [CChar] = []
for ch in N {
    if ch % 2 == 0 {
        evens.append(ch)
    } else {
        odds.append(ch)
    }
}
var res : [CChar] = []
while !evens.isEmpty || !odds.isEmpty {
    if evens.isEmpty {
        res.append(odds.removeFirst())
    } else if odds.isEmpty || evens.first! > odds.first! {
        res.append(evens.removeFirst())
    } else {
        res.append(odds.removeFirst())
    }
}
print(String(cString: res))
