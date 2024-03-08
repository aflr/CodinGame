const N = +readline();
console.log(N - 1 ? 2 * (N - (1 << 31 - Math.clz32(N - 1))) : 1);
