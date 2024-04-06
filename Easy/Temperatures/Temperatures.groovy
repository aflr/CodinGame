s = new Scanner(System.in)
def (i, r, a) = [s.nextInt(), 0, {Math.abs(it)}]
while (i--) {
    t = s.nextInt()
    r ?= t
    r = a(t) < a(r) ? t : r
    r = a(t) == a(r) ? Math.max(t, r) : r
}
println r
