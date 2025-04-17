<template>
  <div class="container mt-2">
    <h2><i class="fa-solid fa-address-card"></i> 연락처</h2>
    <div class="row">
      <!-- v-if="Contacts"를 사용하는 방법도 있음, v-else로 Loading 처리 가능 -->
      <div class="col">
        <img class="rounded" :src="Contact?.photo" :alt="Contact?.name" />
      </div>
      <div class="col">
        <p>ID</p>
        <p>name</p>
        <p>tel</p>
        <p>address</p>
      </div>
      <div class="col">
        <!-- optional Chaining 사용 -->
        <p>{{ Contact?.id }}</p>
        <p>{{ Contact?.name }}</p>
        <p>{{ Contact?.tel }}</p>
        <p>{{ Contact?.address }}</p>
      </div>
    </div>
    <div class="d-flex justify-content-center">
      <RouterLink class="btn btn-primary me-1" to="/contacts"
        ><i class="fa-solid fa-list"></i> 목록</RouterLink
      >
      <RouterLink class="btn btn-primary me-1" :to="{ path: `/contacts/edit/${ContactId}` }"
        ><i class="fa-solid fa-pen-to-square"></i> 수정</RouterLink
      >
      <button class="btn btn-danger" @click="handleDelete">
        <i class="fa-solid fa-trash-can"></i> 삭제
      </button>
    </div>
  </div>
</template>
<script setup>
import axios from 'axios'
import { onMounted, ref } from 'vue'
import { RouterLink, useRoute, useRouter } from 'vue-router'

const url = 'http://localhost:3000/contacts/'
const Contact = ref(null)
const error = ref(null)
const route = useRoute()
const router = useRouter()
const ContactId = route.params.id

const getContactById = async (id) => {
  try {
    const response = await axios.get(url + `${id}`)
    console.log(response.data)
    return response.data
  } catch (err) {
    error.value = err.message || '연락처 조회 실패'
    console.log(err)
  }
}

const handleDelete = async () => {
  if (!confirm('정말 삭제하시겠습니까?')) return
  try {
    await axios.delete(`${url}+${ContactId}`)
    router.push('/contacts')
  } catch (err) {
    error.value = err.message || '연락처 삭제 실패'
    console.log(err)
  }
} // error

onMounted(async () => {
  Contact.value = await getContactById(ContactId)
  console.log('Contact: ', Contact)
})
</script>
