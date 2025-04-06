<template>
  <li
    class="list-group-item"
    :class="{ 'list-group-item-success': item.completed }"
    @click="toggleCompleted(item.id)"
  >
    <span class="pointer ms-2" :class="{ 'todo-done': item.completed }">
      {{ item.todo }} {{ item.completed ? "(완료)" : "" }}
    </span>
    <span
      class="float-end badge bg-secondary pointer"
      @click.stop="deleteTodo(item.id)"
    >
      삭제</span
    >
  </li>
</template>
<script>
export default {
  name: "TodoListItem",
  props: {
    item: Object,
  },
  emits: ["delete-todo", "toggle-completed"], // 이벤트 명시
  methods: {
    deleteTodo(id) {
      this.$emit("delete-todo", id);
    },
    toggleCompleted(id) {
      this.$emit("toggle-completed", id);
    },
  },
};
</script>
