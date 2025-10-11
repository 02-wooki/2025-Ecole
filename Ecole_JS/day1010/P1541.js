const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim();

const str = input.split("-");
let ans = str[0].split("+").map(Number).reduce((a, b) => a + b);

for (let i = 1; i < str.length; i++)
  ans -= str[i].split("+").map(Number).reduce((a, b) => a + b);

console.log(ans);

