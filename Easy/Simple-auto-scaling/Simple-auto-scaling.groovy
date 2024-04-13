sc = new Scanner(System.in);
def (S, M) = [sc.nextInt(), sc.nextInt()]
def (cpi, ms) = [[], new int[M+1][S]]
for (i in 1..S)
    cpi << sc.nextInt()
for (i in 0..<M) {
    res = [];
    for (j in 0..<S) {
        ms[i+1][j] = sc.nextInt()
        res << (Math.ceil(ms[i+1][j].div(cpi[j]))
                - Math.ceil(ms[i][j].div(cpi[j])) as int)
    }
    println res.join(' ')
}
