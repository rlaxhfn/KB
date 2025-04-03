// then-catch 사용
fetch('https://jsonplaceholder.typicode.com/users')
  .then((response) => {
    if (!response.ok) {
      throw new Error('데이터 불러오기를 실패했습니다.');
    }
    return response.json();
  })
  .then((users) => console.log(users))
  .catch((error) => console.log(error));
