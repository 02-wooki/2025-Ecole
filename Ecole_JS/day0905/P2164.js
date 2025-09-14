const n = parseInt(require('fs').readFileSync('/dev/stdin').toString().trim());

let arr = [], left = 0;
for (let i = 1; i <= n; i++)
  arr.push(i);

while (left < arr.length - 1) {
  arr.push(arr[left + 1]);
  left += 2
}

console.log(arr[left])

