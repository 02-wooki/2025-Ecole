const [m, n] = require('fs')
        .readFileSync('/dev/stdin')
        .toString()
        .trim()
        .split(' ')
        .map(Number);

let che = Array.from({length: n + 1}, () => false);
che[1] = true;

for (let i = 2; i <= Math.sqrt(n); i++) {
  if (che[i])
    continue;

  for (let j = i + i; j <= n; j += i)
    che[j] = true;
}

for (let i = m; i <= n ; i++)
  if (!che[i])
    console.log(i);

