import sys
input = sys.stdin.readline

n, m = map(int, input().split())
lessons = list(map(int, input().split()))

min, max = max(lessons), sum(lessons)
while min <= max:
    mid = (min + max) // 2

    sum, count = 0, 0
    for i in lessons:
        if sum + i > mid:
            count += 1
            sum = 0
        sum += i
    if sum != 0:
        count += 1

    if count > m:
        min = mid + 1 
    else:
        max = mid - 1

print(min)

