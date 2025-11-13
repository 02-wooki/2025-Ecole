const input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')

const n = parseInt(input[0]);
let parents = new Array(n - 1).fill(0);
let visited = new Array(n - 1).fill(false);
let edges = [];
for (let i = 0; i < n; i++)
  edges.push([]);

function dfs(node) {
  visited[node] = true;
  for (let i of edges[node])
    if (!visited[i]) {
      parents[i] = node;
      dfs(i);
    }
}

for (let i = 1; i < n; i++) {
  const [s, e] = input[i].split(' ').map(Number);
  edges[s - 1].push(e - 1);
  edges[e - 1].push(s - 1);
}

dfs(0);

for (let i = 1; i < n; i++)
  console.log(parents[i] + 1);

