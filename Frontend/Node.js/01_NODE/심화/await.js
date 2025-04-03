// async과 await -> 비동기처리 속 동기처리
async function init() {
  const usersFetch = await fetch('https://jsonplaceholder.typicode.com/users');
  const users = await usersFetch.json();
  console.log(users);
}

init();
