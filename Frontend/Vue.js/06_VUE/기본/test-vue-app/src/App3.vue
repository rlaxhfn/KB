<template>
  <div>
    <InputName @nameChanged="nameChangedHandler" />
    <br />
    <h3>App data : {{ parentName }}</h3>
  </div>
</template>

<script>
import InputName from './components/InputName.vue';
export default {
  name: 'App3',
  components: { InputName },
  data() {
    return { parentName: '' };
  },
  methods: {
    nameChangedHandler(e) {
      this.parentName = e.name;
    },
  },
};
</script>
