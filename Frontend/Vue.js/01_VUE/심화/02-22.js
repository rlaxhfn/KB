let p = new Promise((resolve, reject) => {
  resolve('first!'); // 성공 결과
});
p.then((msg) => {
  console.log(msg); // 성공 출력
  return 'second'; // 반환
})
  .then((msg) => {
    console.log(msg);
    return 'third';
  })
  .then((msg) => {
    console.log(msg);
  })
  .catch((error) => {
    console.log('오류 발생 ==> ' + error); //실패 출력
  });
