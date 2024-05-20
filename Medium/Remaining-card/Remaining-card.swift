let N = Int32(readLine()!)!
print(N == 1 ? 1 : 2 * (N - (1 << (31 - (N-1).leadingZeroBitCount))))
