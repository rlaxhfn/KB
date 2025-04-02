<template>
  <div>
    X : <input type="text" v-model.number="state.x" /><br />
    Y : <input type="text" v-model.number="state.y" /><br />
    <div>결과 : {{ result }}</div>
  </div>
</template>
<script>
import { reactive, computed } from "vue";
export default {
  name: "Calc4",
  setup() {
    const state = reactive({ x: 10, y: 20 }); // x, y 초기화
    const result = computed(() => {
      return state.x + state.y;
    }); // 덧셈 함수 정의
    return { state, result };
  },
};
</script>
