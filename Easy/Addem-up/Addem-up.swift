let N = Int(readLine()!)!
var cards : [Int] = readLine()!.split(separator: " ").map{Int($0)!}

var cost = 0
while cards.count > 1 {
    cards.sort()
    let num = cards.remove(at: 1) + cards.remove(at: 0)
    cost += num
    cards.append(num)
}
print(cost)
