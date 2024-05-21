import Foundation
var res = INT_FAST32_MAX, n = readLine()
for (i, t) in readLine()!.split(separator: " ").map{Int($0)!}.enumerated() {
    if i == 0 {
        res = t
    } else if abs(t) <= abs(res) {
        res = t > 0 || res > 0 ? min(abs(t), abs(res)) : t
    }
}
print(n == "0" ? 0 : res)
