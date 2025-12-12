const n = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim();

let d = [0, 0]
for (let i = 2; i <= n; i++) {
  d[i] = d[i - 1] + 1;
  if (i % 2 === 0 && d[Math.floor(i / 2)] + 1 < d[i])
    d[i] = Math.floor(d[i / 2]) + 1;
  if (i % 3 === 0 && d[Math.floor(i / 3)] + 1 < d[i])
    d[i] = Math.floor(d[i / 3]) + 1;
}

console.log(d[n])
