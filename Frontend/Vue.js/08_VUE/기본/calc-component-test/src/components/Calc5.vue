<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    <div>결과 : {{ result }}</div>
  </div>
</template>
<script>
import { watch, ref } from "vue";
export default {
  name: "Calc5",
  setup() {
    const x = ref(0); // 0으로 초기화
    const result = ref(0); // 0으로 초기화
    watch(x, (cur, old) => {
      console.log(`${old} => ${cur}`); // 이전 값과 새로운 값 콘솔 출력
      result.value = cur; // result에 cur 할당
    });
    return { x, result };
  },
};
</script>
