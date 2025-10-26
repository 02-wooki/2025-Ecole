const input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')
    .map((v) => {
      return v.split(' ').map(Number);
    });

const [v, e] = input.shift();
const [k] = input.shift();
let a = Array.from({ length : v + 1 }, () => []);
let visited = Array.from({ length : v + 1 }, () => false);
let distance = Array.from({ length : v + 1 }, () => Number.MAX_VALUE);
distance[k] = 0;

for (const [u, v, w] of input)
  a[u].push([v, w]);

q = [k];
while (q.length > 0) {
  const cur = q.shift();
  if (visited[cur])
    continue;
  visited[cur] = true;

  for (const [next, weight] of a[cur]) {
    if (distance[next] <= distance[cur] + weight)
      continue;
    distance[next] = distance[cur] + weight;
    q.push(next);
  }
}

distance.slice(1).forEach((data) => {
  console.log(data >= Number.MAX_VALUE ? 'INF' : data);
});