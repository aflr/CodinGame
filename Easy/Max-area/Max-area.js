const n = parseInt(readline());
var inputs = readline().split(' ');
let i = 0, e = n - 1, max = 0;
while (i < e) {
    const a = parseInt(inputs[i]), b = parseInt(inputs[e]);
    max = Math.max(max, Math.min(a, b) * (e - i));
    a < b ? i++ : e--;
}
console.log(max);
