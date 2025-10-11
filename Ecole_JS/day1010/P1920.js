const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

function binarySearch(arr, target, left, right) {
  if (left > right)
    return "0";

  const mid = Math.floor(left + (right - left) / 2);
  if (arr[mid] < target)
    return binarySearch(arr, target, mid + 1, right);
  else if (arr[mid] > target)
    return binarySearch(arr, target, left, mid - 1);
  else
    return "1";
}

const a = input[1].split(" ").map(Number);
const x = input[3].split(" ").map(Number);

a.sort((a, b) => a - b);

for (const i of x)
  console.log(binarySearch(a, i, 0, a.length - 1));

