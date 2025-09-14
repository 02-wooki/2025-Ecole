const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

let n = 0;
for (let i = 0; i < input[1].length; i++)
  n += parseInt(input[1][i]);

console.log(n);

