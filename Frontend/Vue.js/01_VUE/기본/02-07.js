// 코드가 비객체지향적임
let arr = [10, 20, 30, 40];
let [a1, a2, a3] = arr;
console.log(a1, a2, a3);
let p1 = { name: '홍길동', age: 20, gender: 'm' };
let { name: n, age: a, gender } = p1;
console.log(n, a, gender); //홍길동, 20, m
