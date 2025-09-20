const arr = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')[1]
    .split(' ')
    .map(Number);

for (let i = 1; i < arr.length; i++) {
  let position = i;
  for (let j = 0; j < i; j++) {
    if (arr[i] <= arr[j]) {
      position = j;
      break;
    }
  }

  const target = arr[i];
  for (let j = i; j > position; j--)
    arr[j] = arr[j - 1];
  arr[position] = target;
}

for (let i = 1; i < arr.length; i++)
  arr[i] += arr[i - 1];

let sum = 0;
for (let i of arr)
  sum += i;

console.log(sum);

