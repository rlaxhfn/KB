// 문서객체선택
let $name = document.getElementById('name');
const $submit = document.querySelector('#btn');

// 이벤트 연결
// $submit.onclick = function () {
//   console.log($name.value); // 입력된 값 가져오기
// };
$submit.addEventListener('click', () => {
  console.log($name.value); // 입력된 값 가져오기
});
