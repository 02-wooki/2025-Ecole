import sys
from collections import deque

input = sys.stdin.readline

def bfs(start_node, graph, colors):
    colors[start_node] = 1
    queue = deque([start_node])

    while queue:
        current_node = queue.popleft()

        for neighbor in graph[current_node]:
            if colors[neighbor] == 0:
                colors[neighbor] = -colors[current_node]
                queue.append(neighbor)
            elif colors[neighbor] == colors[current_node]:
                return False
    
    return True

def solve():
    V, E = map(int, input().split())
    graph = [[] for _ in range(V + 1)]
    colors = [0] * (V + 1)

    for _ in range(E):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)

    is_bipartite = True
    for i in range(1, V + 1):
        if colors[i] == 0:
            if not bfs(i, graph, colors):
                is_bipartite = False
                break
    
    if is_bipartite:
        print("YES")
    else:
        print("NO")

K = int(input())
for _ in range(K):
    solve()

