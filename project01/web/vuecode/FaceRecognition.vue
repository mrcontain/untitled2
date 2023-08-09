<template>
  <div class="face-recognition">
    <p>请将脸部对准摄像头</p>
    <video ref="video" autoplay></video>
    <canvas ref="canvas"></canvas>
    <button @click="capture">拍照</button>
    <button @click="reset">删除</button>
  </div>
</template>

<script>
export default {
  name: 'FaceRecognition',
  data() {
    return {
      count: 0,
    };
  },
  mounted() {
    this.initCamera();
  },
  methods: {
    initCamera() {
      navigator.mediaDevices.getUserMedia({ video: true })
          .then((stream) => {
            const video = this.$refs.video;
            video.srcObject = stream;
            video.play();
          })
          .catch((error) => {
            console.log('无法获取视频流：', error);
          });
    },
    capture() {
      if (this.count < 100) {
        const canvas = this.$refs.canvas;
        const video = this.$refs.video;
        canvas.width = video.videoWidth;
        canvas.height = video.videoHeight;
        const context = canvas.getContext('2d');
        context.drawImage(video, 0, 0, canvas.width, canvas.height);
        canvas.toBlob((blob) => {
          const formData = new FormData();
          formData.append('image', blob, `image${this.count}.jpg`);
          axios.post('http://localhost:8080/pro1/save', formData)
              .then(() => {
                console.log('保存成功');
                this.count++;
                if (this.count < 100) {
                  this.capture();
                }
              })
              .catch((error) => {
                console.log('保存失败：', error);
              });
        });
      } else {
        alert('已经拍摄了100张照片');
      }
    },
    reset() {
      const video = this.$refs.video;
      const stream = video.srcObject;
      const tracks = stream.getTracks();
      tracks.forEach((track) => {
        track.stop();
      });
      video.srcObject = null;
      const canvas = this.$refs.canvas;
      canvas.style.display = 'none';
      this.count = 0;
    },
  },
};
</script>

<style>
.face-recognition {
  margin-top: 20px;
  text-align: center;
}

video {
  width: 100%;
  max-width: 400px;
  height: auto;
  margin-bottom: 10px;
}

canvas {
  display: none;
}
</style>
