import math

m, n = map(int, input().split())
a = [False] * (n + 1)
a[1] = True

for i in range(2, math.floor(math.sqrt(n)) + 1):
    if a[i]:
        continue
    for j in range(i + i, n + 1, i):
        a[j] = True

for i in range(m, n + 1):
    if not a[i]:
        print(i)
