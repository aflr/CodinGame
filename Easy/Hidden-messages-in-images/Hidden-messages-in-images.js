const [w, h] = readline().split(' ').map(s => parseInt(s))
const arr = Array(w * h >> 3).fill("")
for (let i = 0; i < h; i++) {
    const r = readline().split(' ')
    for (let j = 0; j < w; j++) 
        arr[i * w + j >> 3] += r[j] & 1;
}
console.log(arr.map(s => parseInt(s, 2)).map(n => String.fromCharCode(n)).join(""));
