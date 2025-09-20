let input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')
    .map(Number);

input.shift();

for (let i = 0; i < input.length; i++) {
  for (let j = 0; j < input.length - i - 1; j++) {
    if (input[j] > input[j + 1]) {
      const tmp = input[j];
      input[j] = input[j + 1];
      input[j + 1] = tmp;
    }
  }
}

console.log(input.join('\n'));

