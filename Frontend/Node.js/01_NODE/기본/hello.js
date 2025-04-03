//1
function hello(name) {
  console.log(name + '님, 안녕하세요?');
}

hello('홍길동');

//2
function bye(name) {
  return name + '님, 안녕히 가세요.';
}

const name = bye('어피치');
// name = '라이언';
console.log(name);

//3 : 매개변수에 기본값을 설정한 경우
function def(name = '이름없음') {
  return name + '님, 안녕하세요?';
}

const name2 = def();
console.log(name2);

//4
function noname(name) {
  if (name === undefined) return '이름을 입력하세요.';
  else return name + '님, 안녕하세요.';
}

const name3 = noname();
console.log(name3);

//5
const c = require('ansi-colors');
function color(name) {
  console.log(c.green(name) + '님, 안녕하세요?');
}
color('홍길동');
