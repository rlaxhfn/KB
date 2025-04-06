<template></template>
<script setup>
import axios from "axios";

// 에러 처리
const requestAPI = async () => {
  const url = "/api/todos2";
  axios
    .get(url, { timeout: 900 }) // 실패 테스트
    .then((response) => {
      console.log("# 응답객체 : ", response);
    })
    .catch((e) => {
      console.log("에러 발생");
      console.log(e);
      if (e instanceof Error) console.log(e.message);
      else console.log(e);
    }); // error catch
};
requestAPI();
</script>
