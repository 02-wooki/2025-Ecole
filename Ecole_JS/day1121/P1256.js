let [n, m, k] = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split(' ')
    .map(Number);

let d = new Array(202);
for (let i = 0; i < 202; i++)
  d[i] = new Array(i + 1).fill(0);

for (let i = 0; i <= 200; i++) {
  for (let j = 0; j <= i; j++) {
    if (j === 0 || j === i)
      d[i][j] = 1;
    else {
      d[i][j] = d[i - 1][j - 1] + d[i - 1][j];
      if (d[i][j] > 1000000000)
        d[i][j] = 1000000001;
    }
  }
}

if (d[n + m][m] < k)
  process.stdout.write('-1');
else {
  while (!(n === 0 && m === 0)) {
    if (d[n - 1 + m][m] >= k) {
      process.stdout.write('a');
      n--;
    } else {
      process.stdout.write('z');
      k = k - d[n - 1 + m][m];
      m--;
    }
  }
}

