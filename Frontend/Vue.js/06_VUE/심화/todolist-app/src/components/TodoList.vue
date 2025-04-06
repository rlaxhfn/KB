<template>
  <div class="row">
    <div class="col">
      <!--할 일 목록 -->
      <ul class="list-group">
        <TodoListItem
          v-for="item in todoList"
          :key="item.id"
          :item="item"
          @delete-todo="$emit('delete-todo', $event)"
          @toggle-completed="$emit('toggle-completed', $event)"
        />
      </ul>
    </div>
  </div>
</template>
<script>
import TodoListItem from "./TodoListItem.vue";
export default {
  name: "TodoList",
  components: {
    TodoListItem,
  },
  emits: ["delete-todo", "toggle-completed"], // 이벤트 명시
  props: {
    todoList: Array,
  },
};
</script>
