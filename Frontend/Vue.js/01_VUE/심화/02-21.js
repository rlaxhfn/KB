const p = new Promise((resolve, reject) => {
  setTimeout(() => {
    let num = Math.random(); // 0~1 사이의 난수 발생
    if (num >= 0.8) {
      reject('생성된 숫자가 0.8 이상임 - ' + num); // 오류 발생 -> 실패
    }
    resolve(num); // 성공
  }, 2000);
});

p.then((result) => {
  console.log('처리 결과 : ', result); // 성공 출력
}).catch((error) => {
  console.log('오류 : ', error); // 실패 출력
});

console.log('## Promise 객체 생성!');
