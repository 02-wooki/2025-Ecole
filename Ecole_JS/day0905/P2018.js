const fs = require('fs');
const n = parseInt(fs.readFileSync('/dev/stdin').toString().trim());

let count = 0;
let left = 1, right = 1, sum = 1;
while (right <= n) {
  if (sum === n) {
    count++;
    sum += ++right;
  } else if (sum < n)
    sum += ++right;
  else
    sum -= left++;
}

console.log(count);

