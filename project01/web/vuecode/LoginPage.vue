<template>
  <div class="container">
    <h1>人脸识别登录</h1>
    <form @submit.prevent="login">
      <label for="username">用户名</label>
      <input type="text" id="username" v-model="username" required>
      <label for="password">密码</label>
      <input type="password" id="password" v-model="password" required>
      <button type="submit">登录</button>
      <face-recognition></face-recognition>
    </form>
  </div>
</template>

<script>
import FaceRecognition from './FaceRecognition.vue';

export default {
  name: 'LoginPage',
  components: {
    FaceRecognition,
  },
  data() {
    return {
      username: '',
      password: '',
    };
  },
  methods: {
    login() {
      // 处理登录逻辑
    },
  },
};
</script>

<style>
.container {
  max-width: 500px;
  margin: 0 auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 5px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

h1 {
  text-align: center;
  margin-bottom: 20px;
}

form {
  display: flex;
  flex-direction: column;
}

label {
  font-weight: bold;
  margin-bottom: 5px;
}

input[type="text"],
input[type="password"] {
  padding: 10px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: none;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
}

button[type="submit"] {
  padding: 10px;
  background-color: #4CAF50;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
</style>
