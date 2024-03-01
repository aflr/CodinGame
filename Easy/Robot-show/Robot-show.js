const [L, , b] = [readline(), readline(), readline().split(' ')];
console.log(Math.max(Math.max(...b), L - Math.min(...b)));
