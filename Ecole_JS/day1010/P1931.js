let a = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n');

const n = parseInt(a.shift());
for (let i = 0; i < n; i++)
  a[i] = a[i].split(' ').map(Number);

a.sort((s, e) => {
  if (s[1] === e[1])
    return s[0] - e[0];
  return s[1] - e[1];
});

let count = 0, end = -1;
for (let i = 0; i < n; i++) {
  if (a[i][0] >= end) {
    end = a[i][1];
    count++;
  }
}

console.log(count);
