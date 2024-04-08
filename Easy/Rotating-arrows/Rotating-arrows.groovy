def ARROWS = '^>v<^'
def DELTAS = [
    '>' : [0, +1],
    'v' : [+1, 0],
    '<' : [0, -1],
    '^' : [-1, 0]
].asImmutable()
in = new Scanner(System.in)
def (W, H, sx, sy) = [in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()]
def (x, y, grid, rot) = [sx, sy, new char[H][], 0]
for (i in 0..<H)
    grid[i] = in.next().toCharArray()
do {
    grid[y][x] = ARROWS[ARROWS.indexOf(grid[y][x] as int) + 1]
    move = DELTAS["${grid[y][x]}"]
    x += move[1]
    y += move[0]
    ++rot
} while (x >= 0 && y >= 0 && x < W && y < H && (x != sx || y != sy))
println rot
