import sys
input = sys.stdin.readline

n, m, k, x = map(int, input().split())

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)

visited = [-1] * (n + 1)
ans = []

def bfs(node):
    q = [node]
    visited[node] += 1
    while (len(q) > 0):
        cur = q.pop(0)
        for i in graph[cur]:
            if visited[i] == -1:
                visited[i] = visited[cur] + 1
                q.append(i)
bfs(x)

for i in range(n + 1):
    if visited[i] == k:
        ans.append(i)

if len(ans) == 0:
    print(-1)
else:
    ans.sort()
    for i in ans:
        print(i)

        