n = int(input())
arr = list(map(int, input().split()))

for i in range(1, n):
  position = i
  for j in range(0, i):
    if arr[i] < arr[j]:
      position = j
      break
  
  target = arr[i]
  for j in range(i, position, -1):
    arr[j] = arr[j - 1]
  
  arr[position] = target

for i in range(1, n):
  arr[i] += arr[i - 1]

print(sum(arr))
