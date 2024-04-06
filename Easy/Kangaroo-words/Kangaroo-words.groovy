def isKangarooOf(k, j, jj = 0){
    for (i = 0; i < k.size() && jj < j.size(); i++)
        jj += (k[i] == j[jj]) ? 1 : 0
    jj == j.size()
}
in = new Scanner(System.in)
def (N, _) = [in.nextInt(), in.nextLine()]
synonymGroups = []
for (i in 1..N)
    synonymGroups << in.nextLine().split(", ").sort { -it.size() ?: it }
res = [:] as TreeMap
for (s in synonymGroups)
    for (i in 0..<s.size() - 1)
        for (j in (i + 1)..<s.size())
            if (isKangarooOf(s[i], s[j])) {
                res[(s[i])] ?= []
                res[s[i]] << s[j]
            }
if (!res)
    println 'NONE'
else for (en in res)
    println "$en.key: ${en.value.sort().join(', ')}"
