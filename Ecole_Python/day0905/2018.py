n = int(input())
count = 0

left, right, s = 1, 1, 1
while (right <= n):
  if s == n:
    count += 1
    right += 1; s += right
  elif s < n:
    right += 1; s += right
  else:
    s -= left;  left += 1

print(count)

