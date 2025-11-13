import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
parents = [0 for _ in range(n)]
visited = [False] * n
edges = [[] for _ in range(n)]

for i in range(n - 1):
  s, e = map(int, input().split())
  edges[s - 1].append(e - 1)
  edges[e - 1].append(s - 1)

def dfs(node):
  visited[node] = True
  for i in edges[node]:
    if not visited[i]:
      parents[i] = node
      dfs(i)

dfs(0)
for i in range(1, n):
  print(parents[i] + 1)

  