from collections import deque

n, l = map(int, input().split())
arr = list(map(int, input().split()))
q = deque()


for i in range(0, n):
  while q and q[0][0] <= i - l:
    q.popleft()
  while q and q[-1][1] >= arr[i]:
    q.pop()
  
  q.append((i, arr[i]))
  print(q[0][1], end=' ')

  