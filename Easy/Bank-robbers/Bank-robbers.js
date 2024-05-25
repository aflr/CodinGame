let RS = Array(+readline()).fill(0)
for (let i = readline(); i--; RS.sort((a, b) => a - b)) {
    let I = readline().split(' ')
    RS[0] += [125, 625, 3125, 15625, 78125, 390625][I[0] - 3] << I[1]
}
console.log(Math.max(...RS));
