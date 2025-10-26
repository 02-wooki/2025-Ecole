import sys
input = sys.stdin.readline

n = int(input())
a = [[] for _ in range(n + 1)]
indegree = [0 for _ in range(n + 1)]
selfBuild = [0]

for i in range(1, n + 1):
    line = list(map(int, input().split()))
    selfBuild.append(line[0])
    for beforeBuild in line[1:-1]:
        a[beforeBuild].append(i)
        indegree[i] += 1

q, result = [], [0 for _ in range(n + 1)]
for i in range(1, n + 1):
    if indegree[i] == 0:
        q.append(i)

while q:
    current = q.pop(0)

    for neighbor in a[current]:
        indegree[neighbor] -= 1
        result[neighbor] = max(result[neighbor], result[current] + selfBuild[current])
        if indegree[neighbor] == 0:
            q.append(neighbor)

for i in range(1, n + 1):
    print(result[i] + selfBuild[i])
