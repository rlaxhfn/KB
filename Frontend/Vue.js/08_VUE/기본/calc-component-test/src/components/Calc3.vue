<template>
  <div>
    X : <input type="text" v-model.number="state.x" /><br />
    Y : <input type="text" v-model.number="state.y" /><br />
    <button @click="calcAdd">계산</button><br />
    <div>결과 : {{ state.result }}</div>
  </div>
</template>
<script>
import { reactive } from 'vue';
export default {
  name: 'Calc3',
  setup() {
    const state = reactive({ x: 10, y: 20, result: 30 }); // x, y, result 초기화
    const calcAdd = () => {
      state.result = state.x + state.y;
    }; // 덧셈 함수 정의
    return { state, calcAdd };
  },
};
</script>
