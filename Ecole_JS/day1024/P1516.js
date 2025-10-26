let input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')
    .map((i) => {
      return i.split(' ').map(Number);
    })

const [n] = input[0];
let a = Array.from({ length : n + 1 }, () => []);
let indegree = Array.from({ length : n + 1 }, () => 0);
let selfBuild = Array.from({ length : n + 1 }, () => 0);

for (let i = 1; i <= n; i++) {
  selfBuild[i] = input[i].shift();
  input[i].pop();
  for (let preBuild of input[i]) {
    a[preBuild].push(i);
    indegree[i]++;
  }
}

let q = [];
for (let i = 1; i <= n; i++)
  if (indegree[i] === 0)
    q.push(i);

let res = Array.from({ length : n + 1 }, () => 0);
while (q.length > 0) {
  const cur = q.shift();
  for (const neighbor of a[cur]) {
    res[neighbor] = Math.max(res[neighbor], res[cur] + selfBuild[cur]);
    if (--indegree[neighbor] === 0)
      q.push(neighbor);
  }
}

for (let i = 1; i <= n; i++)
  console.log(res[i] + selfBuild[i]);
