const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

function bfs(start, graph, visited) {
    const queue = [start];
    visited[start] = 1;

    while (queue.length > 0) {
        const node = queue.shift();

        for (const neighbor of graph[node]) {
            if (visited[neighbor] === 0) {
                visited[neighbor] = -visited[node];
                queue.push(neighbor);
            } else if (visited[neighbor] === visited[node]) {
                return false;
            }
        }
    }
    return true;
}

let line = 0;
const K = parseInt(input[line++]);

for (let i = 0; i < K; i++) {
    const [V, E] = input[line++].split(' ').map(Number);
    const graph = Array.from({ length: V + 1 }, () => []);
    const visited = Array(V + 1).fill(0);

    for (let j = 0; j < E; j++) {
        const [u, v] = input[line++].split(' ').map(Number);
        graph[u].push(v);
        graph[v].push(u);
    }

    let isBipartite = true;
    for (let j = 1; j <= V; j++) {
        if (visited[j] === 0) {
            if (!bfs(j, graph, visited)) {
                isBipartite = false;
                break;
            }
        }
    }

    console.log(isBipartite ? 'YES' : 'NO');
}
