const input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n');

const [n, m] = input.shift().split(' ').map(Number);
let parent = Array.from({ length : n + 1 }, (v, i) => i)

const find = (x) => {
  if (parent[x] === x)
    return x;
  return parent[x] = find(parent[x]);
}

const union = (a, b) => {
  a = find(a);
  b = find(b);
  if (a !== b)
    parent[b] = a;
}

for (let i = 0; i < m; i++) {
  const [op, a, b] = input[i].split(' ').map(Number);
  if (op === 0)
    union(a, b);
  else
      find(a) === find(b) ? console.log('YES') : console.log('NO');
}

