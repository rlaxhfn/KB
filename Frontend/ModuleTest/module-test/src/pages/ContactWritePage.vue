<template>
  <div class="container mt-2">
    <h2><i class="fa-solid fa-pen-to-square"></i> 새 연락처</h2>
    <div class="mb-3 mt-3">
      <label for="name">name:</label>
      <input
        class="form-control"
        type="text"
        name="name"
        id="name"
        placeholder="이름을 입력하세요."
      />
    </div>
    <div class="mb-3 mt-3">
      <label for="tel">tel:</label>
      <input
        class="form-control"
        type="tel"
        name="tel"
        id="tel"
        placeholder="전화번호를 입력하세요."
      />
    </div>
    <div class="mb-3 mt-3">
      <label for="address">address:</label>
      <input
        class="form-control"
        type="text"
        name="address"
        id="address"
        placeholder="주소를 입력하세요."
      />
    </div>
    <div class="mb-3 mt-3">
      <label for="url">photo url:</label>
      <input
        class="form-control"
        type="text"
        name="url"
        id="url"
        placeholder="사진의 url을 입력하세요."
      />
    </div>
    <div class="d-flex justify-content-center">
      <button type="button" class="btn btn-primary me-1">
        <i class="fa-solid fa-check"></i> 확인
      </button>
      <RouterLink type="button" class="btn btn-primary" to="/contacts">
        <i class="fa-solid fa-rotate-left"></i> 취소
      </RouterLink>
    </div>
  </div>
</template>
<script>
// import { RouterLink } from 'vue-router'
// import axios from 'axios'

// const url = 'http://localhost:3000/contacts/'
// const error = ref(null)
// const router = useRouter()

// const updageContacts = async (newContact) => {
//   try {
//     const response = await axios.post(url, newContact)
//     console.log(response.data)
//     return response.data
//   } catch (err) {
//     error.value = err.message || '연락처 조회 실패'
//     console.log(err)
//   }
// }
</script>
