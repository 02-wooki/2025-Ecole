input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim();

arr = [];
for (let i = 0; i < input.length; i++)
  arr.push(parseInt(input.charAt(i)));

for (let i = 0; i < input.length - 1; i++) {
  let max = -1, maxIndex = -1;

  for (let j = i; j < input.length; j++) {
    if (max < arr[j]) {
      max = arr[j];
      maxIndex = j;
    }
  }

  const tmp = arr[i];
  arr[i] = arr[maxIndex];
  arr[maxIndex] = tmp;
}

console.log(arr.join(''));

