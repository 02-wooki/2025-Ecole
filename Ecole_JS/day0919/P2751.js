const arr = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')
    .map(Number);

arr.shift();

function mergeSort(arr, left, right) {
  if (left >= right)
    return [arr[left]];

  const mid = Math.floor(left + (right - left) / 2);

  const sortedLeft = mergeSort(arr, left, mid);
  const sortedRight = mergeSort(arr, mid + 1, right);

  let leftPointer = 0, rightPointer = 0;
  let sorted = new Array(sortedLeft.length + sortedRight.length), i = 0;

  while (leftPointer < sortedLeft.length && rightPointer < sortedRight.length) {
    if (sortedLeft[leftPointer] <= sortedRight[rightPointer])
      sorted[i++] = sortedLeft[leftPointer++];
    else
      sorted[i++] = sortedRight[rightPointer++];
  }
  while (leftPointer < sortedLeft.length)
    sorted[i++] = sortedLeft[leftPointer++];
  while (rightPointer < sortedRight.length)
    sorted[i++] = sortedRight[rightPointer++];

  return sorted;
}

console.log(mergeSort(arr, 0, arr.length - 1).join('\n'));

