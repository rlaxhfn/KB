<template></template>
<script setup>
import axios from "axios";

// 데이터 추가
const requestAPI = async () => {
  const listUrl = "/api/todos";
  let data = { todo: "윗몸일으키기 3세트", desc: "너무 빠르지 않게..." }; // 추가할 데이터
  const response = await axios.post(listUrl, data);
  console.log(response.data);
};
requestAPI();
</script>
