class PriorityQueue {
  constructor() {
    this.size = 0;
    this.heap = [null];
  }

  put(data) {
    this.heap.push(data);

    let curIndex = this.heap.length - 1;
    let parIndex = Math.floor(curIndex / 2);
    while (parIndex !== 0 && this.heap[parIndex] > data) {
      const tmp = this.heap[parIndex];
      this.heap[parIndex] = this.heap[curIndex];
      this.heap[curIndex] = tmp;
      curIndex = parIndex;
      parIndex = Math.floor(curIndex / 2);
    }

    this.size++;
  }

  get() {
    if (this.size === 0)
      return undefined;

    const returnValue = this.heap[1];
    if (this.size === 1) {
      this.heap.pop();
      this.size--;
      return returnValue;
    }

    this.heap[1] = this.heap.pop();
    this.size--;

    let currentIndex = 1;
    while (true) {
      const leftChildIndex = currentIndex * 2;
      const rightChildIndex = currentIndex * 2 + 1;
      let smallestChildIndex = leftChildIndex;

      if (leftChildIndex > this.size)
        break;
      if (
          rightChildIndex <= this.size &&
          this.heap[rightChildIndex] < this.heap[leftChildIndex]
      )
        smallestChildIndex = rightChildIndex;

      if (this.heap[currentIndex] <= this.heap[smallestChildIndex])
        break;

      [this.heap[currentIndex], this.heap[smallestChildIndex]]= [this.heap[smallestChildIndex], this.heap[currentIndex]];
      currentIndex = smallestChildIndex;
    }

    return returnValue;
  }
}

let cards = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n')
    .map(Number);

const n = cards.shift();
const q = new PriorityQueue();
let sum = 0;

for (let i of cards)
  q.put(i);

while (q.size > 1) {
  const i = q.get() + q.get();
  sum += i;
  q.put(i);
}

console.log(sum);
