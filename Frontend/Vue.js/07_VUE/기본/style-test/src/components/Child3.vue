<template>
  <div :class="$style.child"><h2>Child1</h2></div>
</template>
<script>
export default {
  name: "Child3",
  created() {
    console.log(this.$style.child);
  },
};
</script>
<style module>
.child {
  background-color: orange;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>
