import sys
input = sys.stdin.readline

n = int(input())
arr = list(int(input()) for _ in range(n))

def mergeSort(left, right):
  if left >= right:
    return [arr[left]]
  
  mid = left + (right - left) // 2
  leftArr = mergeSort(left, mid)
  rightArr = mergeSort(mid + 1, right)

  leftIdx, rightIdx = 0, 0
  sorted = []
  while leftIdx < len(leftArr) and rightIdx < len(rightArr):
    if leftArr[leftIdx] < rightArr[rightIdx]:
      sorted.append(leftArr[leftIdx])
      leftIdx += 1
    else:
      sorted.append(rightArr[rightIdx])
      rightIdx += 1

  while leftIdx < len(leftArr):
    sorted.append(leftArr[leftIdx])
    leftIdx += 1
  while rightIdx < len(rightArr):
    sorted.append(rightArr[rightIdx])
    rightIdx += 1
  
  return sorted

print(*mergeSort(0, n - 1), sep='\n')

