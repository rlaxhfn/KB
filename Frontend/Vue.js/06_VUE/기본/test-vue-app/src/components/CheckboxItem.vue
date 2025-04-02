<template>
  <li><input type="checkbox" :checked="checked" /> {{ name }}</li>
</template>
<script>
export default {
  name: 'CheckboxItem',
  // props: ['name', 'checked'],
  // data() {
  //   return {
  //     name: 'option1',
  //     checked: false,
  //   };
  // },

  props: {
    id: [Number, String],
    name: String,
    checked: {
      type: Boolean,
      default: false,
      required: false,
    },
  },
};
</script>
