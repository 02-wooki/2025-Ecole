const fs = require('fs')
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n").map(Number);

let stack = [];
let now = 1;

let ans = "";

for (const i of input.filter((x, i) => i !== 0)) {
  while (now <= i) {
    stack.push(now);
    ans += '+\n';
    now++;
  }

  if (stack.pop() !== i) {
    console.log('NO');
    return;
  } else
    ans += '-\n';
}

console.log(ans)