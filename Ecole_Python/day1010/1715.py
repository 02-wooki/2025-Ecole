from queue import PriorityQueue

n = int(input())
q = PriorityQueue()
for _ in range(n):
    q.put(int(input()))

sum = 0
while q.qsize() > 1:
    i = q.get() + q.get()
    sum += i
    q.put(i)

print(sum)

