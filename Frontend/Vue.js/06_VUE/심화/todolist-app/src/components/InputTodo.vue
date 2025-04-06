<template>
  <!--새 할 일 추가 -->
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <input
          id="msg"
          type="text"
          class="form-control"
          name="msg"
          placeholder="할일을 여기에 입력!"
          v-model.trim="todo"
          @keyup.enter="addTodo"
        />
        <span class="btn btn-primary input-group-addon" @click="addTodo"
          >추가</span
        >
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "InputTodo",
  data() {
    return {
      todo: "",
    };
  },
  methods: {
    addTodo() {
      if (this.todo.length >= 2) {
        this.$emit("add-todo", this.todo);
        this.todo = "";
      }
    },
  },
};
</script>
