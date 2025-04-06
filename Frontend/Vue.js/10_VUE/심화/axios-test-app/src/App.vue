<template></template>
<script setup>
import axios from "axios";

// api/todos/1 요청
// const requestAPI = () => {
//   const url = "/api/todos/1";
//   axios.get(url).then((response) => {
//     console.log("# 응답객체 : ", response);
//   });
// };
// requestAPI();

// id가 1인 todo
const listUrl = "/api/todos";
const todoUrlPrefix = "/api/todos/";

// promise의 then/catch
const requestAPI = () => {
  let todoList = [];
  axios
    .get(listUrl)
    .then((response) => {
      todoList = response.data;
      console.log("# TodoList : ", todoList); // todo 목록

      const todoId1 = todoList.find((todo) => todo.id === "1"); //db에 문자열로 존재
      if (todoId1) {
        return axios.get(todoUrlPrefix + 1); // id가 1인 todo return
      } else {
        throw new Error("id가 1인 todo 없음");
      }
    })
    .then((response) => {
      console.log("## id가 1인 Todo : ", response.data);
    }) // id가 1인 todo
    .catch((error) => {
      console.error(error);
    }); // error
};
requestAPI();
</script>
