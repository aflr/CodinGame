var inputs = readline().split(' ');
let a = parseInt(inputs[0]), ao = a;
let b = parseInt(inputs[1]), bo = b;
while (1) {
    if (b == 0) break;
    console.log(a + "=" + b + "*" + (a / b >> 0) + "+" + a % b);
    a %= b;
    if (a == 0) break;
    console.log(b + "=" + a + "*" + (b / a >> 0) + "+" + b % a);
    b %= a;
}
console.log("GCD(" + ao + "," + bo + ")=" + Math.max(a, b));
