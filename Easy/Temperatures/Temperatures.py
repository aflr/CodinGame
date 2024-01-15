import sys
import math

n = int(input())
res = None
for i in input().split():
    t = int(i)
    res = (t if res == None or abs(t) < abs(res) else res)
    res = (max(t, res) if abs(t) == abs(res) else res)
print(res if n > 0 else 0)
