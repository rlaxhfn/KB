<template>
  <div class="container mt-2">
    <h2><i class="fa-solid fa-address-book"></i> 연락처</h2>
    <table class="table table-borderless">
      <thead>
        <tr>
          <th scope="col">id</th>
          <th scope="col">name</th>
          <th scope="col">tel</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="c in Contacts" :key="c.id">
          <td scope="row">{{ c.id }}</td>
          <td>
            <img
              class="rounded-circle me-1"
              style="width: 25px"
              :src="c.photo"
              :alt="c.name"
            /><RouterLink :to="{ path: `/contacts/detail/${c.id}` }">{{ c.name }}</RouterLink>
          </td>
          <td>{{ c.tel }}</td>
        </tr>
      </tbody>
    </table>
    <div class="d-flex flex-row-reverse">
      <RouterLink class="btn btn-primary" to="/contacts/write">
        <i class="fa-solid fa-pen-to-square"></i> 새 연락처
      </RouterLink>
    </div>
  </div>
</template>
<script setup>
import axios from 'axios'
import { onMounted, ref } from 'vue'
import { RouterLink } from 'vue-router'

const url = 'http://localhost:3000/contacts'
const Contacts = ref([])
const error = ref(null)

const fetchContacts = async () => {
  try {
    const response = await axios.get(url)
    console.log(response)
    Contacts.value = response.data
    console.log(Contacts)
  } catch (err) {
    error.value = err.message || '데이터 요청 중 에러 발생'
    console.log(err)
  }
}

onMounted(() => fetchContacts()) // onMounted() 필요
</script>
