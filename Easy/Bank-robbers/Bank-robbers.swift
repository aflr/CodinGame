let R = Int(readLine()!)!, V = Int(readLine()!)!
var rs = Array(repeating: 0, count: R)
for i in 0..<V {
    let I = readLine()!.split(separator: " ").map{Int($0)!}
    rs[0] += [125,625,3125,15625,78125,390625][I[0] - 3] << I[1]
    rs.sort()
}
print(rs.last!)
