import { defineStore } from "pinia";
import { reactive, computed } from "vue";
import axios from "axios";

export const useTodoListStore = defineStore("todoList", () => {
  const BASEURI = "/api/todos";
  const state = reactive({
    todoList: [],
  });

  const fetchTodoList = async () => {
    try {
      const response = await axios.get(BASEURI);
      if (response.status === 200) {
        state.todoList = response.data;
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
      if (response.status === 201) {
        state.todoList.push({ ...response.data, done: false });
        successCallback();
      } else {
        alert("Todo 추가 실패");
      }
    } catch (error) {
      alert("에러발생 :" + error);
    }
  };

  const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
    try {
      const payload = { id, todo, desc, done };
      const response = await axios.put(BASEURI + `/${id}`, payload);
      if (response.status === 200) {
        let index = state.todoList.findIndex((todo) => todo.id === id);
        state.todoList[index] = payload;
        successCallback();
      } else {
        alert("Todo 변경 실패");
      }
    } catch (error) {
      alert("에러발생 :" + error);
    }
  };

  const deleteTodo = async (id) => {
    try {
      const response = await axios.delete(BASEURI + `/${id}`);
      if (response.status === 200) {
        let index = state.todoList.findIndex((todo) => todo.id === id);
        state.todoList.splice(index, 1);
      } else {
        alert("Todo 삭제 실패");
      }
    } catch (error) {
      alert("에러발생 :" + error);
    }
  };

  const toggleDone = async (id) => {
    try {
      let todo = state.todoList.find((todo) => todo.id === id);
      let payload = { ...todo, done: !todo.done };
      const response = await axios.put(BASEURI + `/${id}`, payload);
      if (response.status === 200) {
        todo.done = payload.done;
      } else {
        alert("Todo 완료 변경 실패");
      }
    } catch (error) {
      alert("에러발생 :" + error);
    }
  };

  const todoList = computed(() => state.todoList);
  const doneCount = computed(() => {
    const filtered = state.todoList.filter(
      (todoItem) => todoItem.done === true
    );
    return filtered.length;
  });

  return {
    todoList,
    doneCount,
    fetchTodoList,
    addTodo,
    updateTodo,
    deleteTodo,
    toggleDone,
  };
});
