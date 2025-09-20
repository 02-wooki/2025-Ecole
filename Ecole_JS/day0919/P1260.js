const input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')

for (let i = 0; i < input.length; i++)
  input[i] = input[i].split(' ').map(Number);

const [n, m, v] = input[0];

const edgeList = [];
for (let i = 0; i < n; i++)
  edgeList.push(new Array(0));

for (let i = 1; i < input.length; i++) {
  const [s, e] = [input[i][0] - 1, input[i][1] - 1];
  edgeList[s].push(e);
  edgeList[e].push(s);
}

for (let i = 0; i < edgeList.length; i++)
  edgeList[i].sort((a, b) => a - b);

let visited = new Array(n).fill(false);
let res = [];

function dfs(node) {
  visited[node] = true;
  res.push(node + 1);
  for (const n of edgeList[node]) {
    if (!visited[n])
      dfs(n);
  }
}

dfs(v - 1);
console.log(res.join(' '));

visited = new Array(n).fill(false);
res = [];
let queue = [];
let i = 0;

queue.push(v - 1);
visited[v - 1] = true;
while (queue.length > i) {
  const node = queue[i++];
  res.push(node + 1);
  for (const n of edgeList[node]) {
    if (!visited[n])
      queue.push(n);
      visited[n] = true;
  }
}

console.log(res.join(' '));