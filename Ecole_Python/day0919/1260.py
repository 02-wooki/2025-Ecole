import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m, v = map(int, input().split())
graph = [list() for i in range(n)]
visited = [False for i in range(n)]
res = []

def dfs(node):
  visited[node] = True
  res.append(node + 1)

  for nextNode in graph[node]:
    if not visited[nextNode]:
      dfs(nextNode)

for _ in range(m):
  u, w = map(int, input().split())
  graph[u - 1].append(w - 1)
  graph[w - 1].append(u - 1)

for i in range(n):
  graph[i].sort()

dfs(v - 1)
print(*res)

res = []
queue = []
visited = [False for _ in range(n)]
visited[v - 1] = True
queue.append(v - 1)

while len(queue) > 0:
    node = queue.pop(0)
    res.append(node + 1)
    for n in graph[node]:
        if not visited[n]:
            queue.append(n)
            visited[n] = True

print(*res)