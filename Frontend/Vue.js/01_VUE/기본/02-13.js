let obj = { result: 0 };
obj.add = function (x, y) {
  function inner() {
    this.result = x + y; // 6행으로 인해 전역개체가 됨
  }
  inner();
};
obj.add(3, 4);

console.log(obj); // {result: 0]}
console.log(result); // 7
