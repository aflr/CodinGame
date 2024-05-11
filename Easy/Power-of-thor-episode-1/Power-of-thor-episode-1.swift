let inputs = (readLine()!).split(separator: " ").map(String.init)
let lightX = Int(inputs[0])! // the X position of the light of power
let lightY = Int(inputs[1])! // the Y position of the light of power
var TX = Int(inputs[2])! // Thor's starting X position
var TY = Int(inputs[3])! // Thor's starting Y position

while true {
    let _ = Int(readLine()!)!
    var str : String = ""
    if lightY > TY {
        TY += 1; str += "S"
    } else if lightY < TY {
        TY -= 1; str += "N"
    }
    if lightX > TX {
        TX += 1; str += "E"
    } else if lightX < TX {
        TX -= 1; str += "W"
    }
    print(str)
}
