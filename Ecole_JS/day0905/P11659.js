const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

let arr = [0];

for (const i of input[1].split(' ').map(Number))
  arr.push(i + arr[arr.length - 1]);

for (const i of input.filter((i, index) => index > 1)) {
  const range = i.split(' ').map(Number);
  console.log(arr[range[1]] - arr[range[0] - 1]);
}
