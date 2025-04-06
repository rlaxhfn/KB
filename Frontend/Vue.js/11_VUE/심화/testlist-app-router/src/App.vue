<template>
  <div class="container">
    <Header />
    <router-view />
  </div>
</template>

<script setup>
import { reactive, provide, computed } from "vue";
import Header from "@/components/Header.vue";
import axios from "axios";

const BASEURI = "/api/todos";
const states = reactive({ todoList: [] });

// 기존 내역 수정+에러 처리
const fetchTodoList = async () => {
  try {
    const response = await axios.get(BASEURI);
    if (response.status === 200) {
      states.todoList = response.data;
    } else {
      alert("데이터 조회 실패");
    }
  } catch (error) {
    alert("에러발생 :" + error);
  }
};

const addTodo = async ({ todo, desc }, successCallback) => {
  try {
    const payload = { todo, desc };
    const response = await axios.post(BASEURI, payload);
    if (response.data.status === "success") {
      states.todoList.push({
        id: response.data.item.id,
        todo,
        desc,
        done: false,
      });
      successCallback();
    } else {
      alert("Todo 추가 실패 : " + response.data.message);
    }
  } catch (error) {
    alert("에러발생 :" + error);
  }
};

const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
  try {
    const payload = { todo, desc, done };
    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.data.status === "success") {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList[index] = { id, todo, desc, done };
      successCallback();
    } else {
      alert("Todo 변경 실패 : " + response.data.message);
    }
  } catch (error) {
    alert("에러발생 :" + error);
  }
};

const deleteTodo = async (id) => {
  try {
    const response = await axios.delete(BASEURI + `/${id}`);
    if (response.data.status === "success") {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList.splice(index, 1);
    } else {
      alert("Todo 삭제 실패 : " + response.data.message);
    }
  } catch (error) {
    alert("에러발생 :" + error);
  }
};

const toggleDone = async (id) => {
  try {
    const target = states.todoList.find((todo) => todo.id === id);
    const payload = { ...target, done: !target.done };

    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.status === 200) {
      target.done = !target.done;
    } else {
      alert("Todo 완료 변경 실패");
    }
  } catch (error) {
    alert("에러발생 :" + error);
  }
}; // json-server: 커스텀 라우터 불가

provide(
  "todoList",
  computed(() => states.todoList)
);
provide("actions", {
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
  fetchTodoList,
});

fetchTodoList();
</script>
