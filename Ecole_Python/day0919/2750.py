arr = list(int(input()) for _ in range(int(input())))

for i in range(len(arr)):
  for j in range(0, len(arr) - i - 1):
    if arr[j] > arr[j + 1]:
      tmp = arr[j]
      arr[j] = arr[j + 1]
      arr[j + 1] = tmp

print(*arr, sep='\n')

