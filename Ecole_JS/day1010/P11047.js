let input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')

let [n, k] = input.shift().split(' ').map(Number);
const coins = input.reverse().map(Number);

let count = 0;

for (let i of coins) {
  if (k >= i) {
    count += Math.floor(k / i);
    k %= i;
  }
}

console.log(count);

