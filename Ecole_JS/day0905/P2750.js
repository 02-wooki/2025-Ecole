const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const arr = input.map(Number)
    .filter((i, index) => index !== 0)
    .sort((a, b) => a - b);

for (const i of arr)
  console.log(i);

