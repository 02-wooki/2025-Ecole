import sys
input = sys.stdin.readline

def binarySearch(arr, target, left, right):
    if left > right:
        return 0

    mid = left + (right - left) // 2
    if arr[mid] > target:
        return binarySearch(arr, target, left, mid - 1)
    elif arr[mid] < target:
        return binarySearch(arr, target, mid + 1, right)
    else:
        return 1

_ = input()
a = list(map(int, input().split()))
a.sort()

_ = input()
x = list(map(int, input().split()))

for i in x:
    print(binarySearch(a, i, 0, len(a) - 1))

    