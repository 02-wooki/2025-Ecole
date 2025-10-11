let n = parseInt(require('fs').readFileSync('/dev/stdin').toString());
let result = n;

for (let p = 2; p <= Math.sqrt(n); p++) {
  if (n % p === 0) {
    result -= result / p;
    while (n % p === 0)
      n /= p;
  }
}

if (n > 1)
  result -= result / n;
console.log(result);
