import sys
input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))

arr.insert(0, 0)
for i in range(1, len(arr)):
  arr[i] = arr[i - 1] + arr[i]

for _ in range(m):
  left, right = map(int, input().split())
  print(arr[right] - arr[left - 1])
  