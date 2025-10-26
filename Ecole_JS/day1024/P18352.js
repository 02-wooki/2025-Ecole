const input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n');

const [n, m, k, x] = input.shift().split(' ').map(Number);
const graph = Array.from({ length: n + 1 }, () => []);
let visited = Array.from({ length: n + 1 }, () => -1);
let ans = [];

for (let i = 0; i < m; i++) {
  const [u, v] = input[i].split(' ').map(Number);
  graph[u].push(v);
}

const bfs = (node) => {
  let q = [node];
  visited[node]++;

  while (q.length > 0) {
    const current = q.shift();
    for (const i of graph[current]) {
      if (visited[i] === -1) {
        visited[i] = visited[current] + 1;
        q.push(i);
      }
    }
  }
}
bfs(x);

for (let i = 1; i <= n; i++)
  if (visited[i] === k)
    ans.push(i);
if (ans.length === 0)
  console.log('-1');
else {
  ans.sort((a, b) => a - b);
  for (const i of ans)
    console.log(i);
}

