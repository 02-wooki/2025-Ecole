n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]

a.sort(key=lambda x: (x[1], x[0]))

count, end = 0, -1
for i in range(n):
    if a[i][0] >= end:
        end = a[i][1]
        count += 1

print(count)
