const L = parseInt(readline()), N = parseInt(readline());
var painted = [], unpainted = [], currEnd = 0;
for (let i = 0; i < N; painted.push([parseInt(inputs[0]), parseInt(inputs[1])]), i++)
    var inputs = readline().split(' ');
painted.sort((o1, o2) => o1[0] - o2[0]);
for (e of painted)
    if (e[0] <= currEnd)
        currEnd = (e[1] > currEnd) ? e[1] : currEnd;
    else if (unpainted.push([currEnd, e[0]]))
        currEnd = e[1];
if (currEnd < L) unpainted.push([currEnd, L]);
unpainted.length ? unpainted.forEach(e => console.log(e[0] + ' ' + e[1])) : console.log('All painted');
