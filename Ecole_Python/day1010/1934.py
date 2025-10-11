def gcd(x, y):
    if y == 0:
        return x
    return gcd(y, x % y)

for _ in range(int(input())):
    x, y = map(int, input().split())
    print(x * y // gcd(x, y))
    