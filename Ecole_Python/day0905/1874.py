n = int(input())
stack, pointer = [], 1
res, possible = '', True

for _ in range(n):
  target = int(input())
  
  while pointer <= target:
    res += '+\n'
    stack.append(pointer)
    pointer += 1
  
  top = stack.pop()
  if top == target:
    res += '-\n'
  else:
    possible = False
    break

print(res if possible else 'NO')

