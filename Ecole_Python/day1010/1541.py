import sys
input = sys.stdin.readline

str = list(input().split("-"))
num = sum(map(int, str[0].split("+")))

for i in range(1, len(str)):
  num -= sum(map(int, str[i].split("+")))

print(num)

