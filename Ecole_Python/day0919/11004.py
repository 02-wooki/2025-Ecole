import sys
input = sys.stdin.readline

n, k = map(int, input().split())
arr = list(map(int, input().split()))
k -= 1

def quick(left, right):
  if right - left < 2:
    return max(arr[left], arr[right]) if k == right else min(arr[left], arr[right])

  mid = left + (right - left) // 2
  arr[mid], arr[left] = arr[left], arr[mid]

  i, j = left + 1, right
  while i <= j:
    while arr[j] > arr[left] and i <= j:
      j -= 1
    while arr[i] < arr[left] and i <= j:
      i += 1
    if i <= j:
      arr[i], arr[j] = arr[j], arr[i]
      i += 1
      j -= 1
  
  arr[left], arr[j] = arr[j], arr[left]

  if j == k:
    return arr[j]
  elif j < k:
    return quick(j + 1, right)
  else:
    return quick(left, j - 1)

print(quick(0, n - 1))

