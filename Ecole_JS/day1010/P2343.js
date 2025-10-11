const input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')

const [n, m] = input[0].split(' ').map(Number);
const lessons = input[1].split(' ').map(Number);
let min = Math.max(...lessons);
let max = lessons.reduce((acc, curr) => acc + curr, 0);

while (min <= max) {
  const mid = Math.floor((min + max) / 2);
  let sum = 0, count = 0;

  for (const i of lessons) {
    if (sum + i > mid) {
      count++;
      sum = 0;
    }
    sum += i;
  }
  if (sum > 0)
    count++;

    count > m ? (min = mid + 1) : (max = mid - 1);
}

console.log(min);

