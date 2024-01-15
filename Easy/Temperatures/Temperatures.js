const n = parseInt(readline());
var inputs = readline().split(' ');
let res = 0;
for (let i = 0; i < n; i++) {
    const t = parseInt(inputs[i]);
    i == 0 ? res = t : null;
    Math.abs(t) < Math.abs(res) ? res = t : null;
    Math.abs(t) == Math.abs(res) ? res = Math.max(res, t) : null;
}
console.log(res);
