let input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n');

const gcd = (a, b) => {
  if (b === 0)
    return a;
  return gcd(b, a % b);
}

const t = parseInt(input[0]);
for (let i = 0; i < t; i++) {
  const [a, b] = input[i + 1].split(' ').map(Number);
  console.log(Math.floor(a * b / gcd(a, b)));
}
