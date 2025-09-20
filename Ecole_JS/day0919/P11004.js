const input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n');
const [n, k] = input[0].split(' ');
let arr = input[1].split(' ').map(Number);

function swap(arr, i1, i2) {
  const tmp = arr[i1];
  arr[i1] = arr[i2];
  arr[i2] = tmp;
}

function quickSort(arr, k, left, right) {
  if (right - left < 2)
    return k === left ?
    Math.min(arr[left], arr[right])
    : Math.max(arr[left], arr[right]);

  const mid = Math.floor(left + (right - left) / 2);
  swap(arr, mid, left);

  let i = left + 1, j = right;
  while (i <= j) {
    while (i <= j && arr[left] < arr[j])
      j--;
    while (i <= j && arr[left] > arr[i])
      i++;
    if (i <= j)
      swap(arr, i++, j--);
  }

  swap(arr, left, j);
  if (k === j)
    return arr[j];
  else if (k < j)
    return quickSort(arr, k, left, j - 1)
  else
    return quickSort(arr, k, j + 1, right);
}

console.log(quickSort(arr, k - 1, 0, n - 1));

