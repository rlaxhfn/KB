<template>
  <input
    type="text"
    :value="name"
    placeholder="이름을 입력하세요"
    @input="$emit('update:name', $event.target.value)"
  />
</template>
<script>
export default {
  name: "InputName",
  props: ["name"],
};
</script>
