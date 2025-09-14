const input = require('fs')
    .readFileSync('/dev/stdin')
    .toString()
    .trim()
    .split('\n');
const [n, l] = input[0].split(' ').map(Number);
const arr = input[1].split(' ').map(Number);

class Node {
  constructor(value, index) {
    this.value = value;
    this.index = index;
    this.next = null;
    this.prev = null;
  }
}

class Deque {
  constructor() {
    this.head = null;
    this.tail = null;
    this.isEmpty = true;
  }

  push(node) {

    while (!this.isEmpty && this.tail.value >= node.value) {
      this.tail = this.tail.prev;

      this.isEmpty = this.tail === null;
      if (!this.isEmpty)
        this.tail.next = null;
    }

    if (this.isEmpty) {
      this.head = node;
      this.tail = node;
      this.isEmpty = false;
    } else {
      this.tail.next = node;
      node.prev = this.tail;
      this.tail = node;
    }
  }

  popLeft(size) {
    while (!this.isEmpty && this.head.index <= size) {
      this.head = this.head.next;

      this.isEmpty = this.head === null;
      if (!this.isEmpty)
        this.head.prev = null;
    }
  }
}

const deque = new Deque();
let res = '';
for (let i = 0; i < n; i++) {
  deque.popLeft(i - l);
  deque.push(new Node(arr[i], i));

  res += deque.head.value + ' ';

  if (i % 10000 === 0) {
    process.stdout.write(res.trim() + ' ');
    res = '';
  }
}

process.stdout.write(res.trim());

