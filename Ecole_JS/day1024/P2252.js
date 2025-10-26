const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, M] = input[0].split(' ').map(Number);
const graph = Array.from({ length: N + 1 }, () => []);
const inDegree = Array(N + 1).fill(0);

for (let i = 1; i <= M; i++) {
    const [A, B] = input[i].split(' ').map(Number);
    graph[A].push(B);
    inDegree[B]++;
}

const queue = [];
for (let i = 1; i <= N; i++) {
    if (inDegree[i] === 0) {
        queue.push(i);
    }
}

const result = [];
while (queue.length > 0) {
    const node = queue.shift();
    result.push(node);

    for (const neighbor of graph[node]) {
        inDegree[neighbor]--;
        if (inDegree[neighbor] === 0) {
            queue.push(neighbor);
        }
    }
}

console.log(result.join(' '));
