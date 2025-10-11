n, k = map(int, input().split())
coins = list(int(input()) for _ in range(n))
coins.reverse()

count = 0
for i in coins:
    if k >= i:
        count += k // i
        k %= i

print(count)
