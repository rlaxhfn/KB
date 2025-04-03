// 변수, 상수 선언
// 1. 문서객체선택
let $foods = document.getElementsByName('food');
const $selectAll = document.getElementsByName('select-all');
const $submit = document.getElementById('btn');
let $count = 0; // 체크카운트용 변수 선언
let $checkedBox = ''; // 체크확인용 변수 선언

// 함수정의
// 1. 전체선택
function checkAll() {
  $checkedBox = ''; // 변수 초기화
  $foods.forEach(($food) => {
    $food.checked = true; // checked 추가
    $checkedBox += $food.value + ', '; // 체크된 내용값 할당
  });
  $checkedBox = $checkedBox.slice(0, -2);
}
// 2. 전체해제
function removeAll() {
  $foods.forEach(($food) => ($food.checked = false));
}
// 3. 개별선택: 개별선택개수에 따라 전체체크박스 상태 변경
function checkOne() {
  $count = 0; // 카운트용 변수 초기화
  $checkedBox = ''; //변수 초기화
  // 1) 체크박스가 개별적으로 체크가 됐는지 확인
  $foods.forEach(($food) => {
    // 체크가 됐다면
    if ($food.checked) {
      $checkedBox += $food.value + ', '; // 체크된 내용값 할당
      $count += 1; // 체크된 개수값 할당
    }
  });

  $checkedBox = $checkedBox.slice(0, -2); //마지막 ', ' 삭제
  // 2) 개별체크박스 개수 확인
  // (1) 개별적으로 전체를 선택했다면
  if ($count == $foods.length) {
    $selectAll[0].checked = true; // 전체선택 박스 체크
  } else {
    $selectAll[0].checked = false; // (2) 그 외의 모든 경우는 전체선택 박스 체크 해제
  }
}

// 이벤트연결
// 1. 개별체크박스를 클릭할 때: 전체체크박스 상태 변경을 위함
$foods.forEach(($food) => $food.addEventListener('click', checkOne));
// 2. 전체체크박스를 클릭할 때
$selectAll[0].addEventListener('click', () => {
  if ($selectAll[0].checked) {
    checkAll(); // (1) 체크박스가 체크됐다면 전체선택함수 실행
  } else {
    $count = 0; // 기존 개수값 초기화
    removeAll(); // (2) 체크박스가 체크되지 않았다면 전체해제함수 실행
  }
});
// 3. 전송버튼을 클릭할 때
$submit.addEventListener('click', () => {
  // 1) 전체체크박스가 체크됐을 때, 콘솔 출력
  if ($selectAll[0].checked) {
    console.log('전체를 체크했습니다.');
    console.log($checkedBox);
  }
  // 2) 체크박스가 모두 체크되지 않았을 때, 콘솔 출력
  else if ($selectAll[0].checked == false && $count == 0) {
    console.log('아무것도 선택돼지 않았어요! 다시 선택해 주세요.');
  }
  // 3) 개별체크박스가 체크됐을 때, 콘솔 출력
  else {
    checkOne();
    console.log($count + '개를 체크했습니다.'); //콘솔에 출력
    console.log($checkedBox);
  }
});
