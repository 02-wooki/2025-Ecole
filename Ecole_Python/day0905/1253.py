_ = input()
arr = sorted(list(map(int, input().split())))

count = 0
for i in range(0, len(arr)):
  left, right = 0, len(arr) - 1
  while(left < right):
    if (left == i):
      left += 1
      continue
    elif (right == i):
      right -= 1
      continue

    if (arr[left] + arr[right] < arr[i]):
      left += 1
    elif (arr[left] + arr[right] > arr[i]):
      right -= 1
    else:
      count += 1
      break

print(count)

