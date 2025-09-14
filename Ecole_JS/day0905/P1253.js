const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const arr = input[1].split(' ').map(Number);
arr.sort((a, b) => a - b);

let count = 0;
for (let i = 0; i < arr.length; i++) {
  let left = 0, right = arr.length - 1;
  while (left < right) {
    if (left === i) {
      left++;
      continue;
    } else if (right === i) {
      right--;
      continue;
    }

    if (arr[left] + arr[right] > arr[i])
      right--;
    else if (arr[right] + arr[left] < arr[i])
      left++;
    else {
      count++;
      break;
    }
  }
}

console.log(count);

