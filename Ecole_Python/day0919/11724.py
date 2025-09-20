import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n, m = map(int, input().split())
edgeList = [list() for _ in range(n)]
visited = [False for _ in range(n)]

def dfs(node):
  visited[node] = True
  for nextNode in edgeList[node]:
    if not visited[nextNode]:
      dfs(nextNode)

for _ in range(m):
  u, v = map(int, input().split())
  edgeList[u - 1].append(v - 1)
  edgeList[v - 1].append(u - 1)

count = 0

for i in range(n): 
  if not visited[i]:
    visited[i] = True
    dfs(i)
    count += 1

print(count)
