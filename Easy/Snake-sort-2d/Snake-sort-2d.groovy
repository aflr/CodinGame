class Apple{def n,r,c; Apple(N,R,C){ n = N; r = R; c = C}; String toString(){n}}
in = new Scanner(System.in);
def rows = new TreeMap<Integer, List<Apple>>().withDefault{_->[] as List<Apple>}
for (_ in 1..in.nextInt()) {
    apple = new Apple(in.next(), in.nextInt(), in.nextInt());
    rows.get(apple.r) << apple;
}
def res = []
rows.eachWithIndex{k,v,i->{v.sort{it.c};res<<(i%2?v.reverse():v).join(',')}}
println res.join(',')
