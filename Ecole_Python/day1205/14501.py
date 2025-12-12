n = int(input())
p = [list(map(int, input().split())) for _ in range(n)]
d = [0 for _ in range(n + 1)]

for i in range(n - 1, -1, -1):
  if i + p[i][0] > n + 1:
    d[i] = d[i + 1]
  else:
    d[i] = max(d[i + 1], d[i + p[i][0]] + p[i][1])

print(d[0])