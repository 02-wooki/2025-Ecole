const input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')

const [n, m] = input[0].split(' ').map(Number);
let edgeList = new Array(n);
let visited = new Array(n).fill(false);

function dfs(node) {
  visited[node] = true;
  for (const i of edgeList[node]) {
    if (!visited[i])
      dfs(i);
  }
}

for (let i = 0; i < n; i++)
  edgeList[i] = new Array(0);
for (let i = 1; i < input.length; i++) {
  const [u, v] = input[i].split(' ').map(Number);
  edgeList[u - 1].push(v - 1);
  edgeList[v - 1].push(u - 1);
}

let count = 0;
for (let i = 0; i < n; i++) {
  if (!visited[i]) {
    visited[i] = true;
    dfs(i);
    count++;
  }
}

console.log(count);
