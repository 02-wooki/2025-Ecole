arr = list(map(int, list(input())))

for i in range(len(arr) - 1):
  max, maxIndex = -1, -1
  for j in range(i, len(arr)):
    if max < arr[j]:
      max, maxIndex = arr[j], j
    
  tmp = arr[i]
  arr[i] = max
  arr[maxIndex] = tmp
  
print(*arr, sep='')

