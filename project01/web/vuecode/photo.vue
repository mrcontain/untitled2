<template>
  <div>
    <el-dialog v-el-drag-dialog width="720px" :title="title" :close-on-click-modal="false" :visible.sync="dialogPhotoVisible">
      <div v-show="!noShow" class="pictureBox">
        <div>
          <div v-show="cameraShow" id="my_camera">
            <video id="videoCamera" :width="videoWidth" :height="videoHeight" autoplay></video>
            <canvas style="display:none;" id="canvasCamera" :width="videoWidth" :height="videoHeight"></canvas>
          </div>

          <div v-show="!cameraShow" class="camera_no">
            <div>
              <i class="el-icon-loading"/>
            </div>
            <div class="text">{{ loadingText }}</div>
          </div>
        </div>
        <div class="picList">
          <div v-for="(s, index) in listSrc" style="position: relative">
            <el-image
                style="width: 100%; height: 130px"
                :src="s.src"
                :preview-src-list="getSrcList(index)" lazy>
            </el-image>
            <i class="el-icon-error" @click="delClick(s)"></i>
          </div>

        </div>
      </div>
      <div v-show="noShow" class="camera_no_data">
        <div>
          <i class="el-icon-loading"/>
        </div>
        <div class="text">{{ loadingErrorText }}</div>
      </div>

      <div class="btn-group" v-show="!noShow">
        <div class="btn-cn" v-show="cameraShow">
          <el-button type="warning" :loading="saveLoading" @click="takeSnapShot()">拍照</el-button>
          <el-button v-if="listSrc.length !== 0" type="danger" :loading="saveLoading" @click="againTakePhoto()">清空</el-button>
          <el-button type="primary" :loading="saveLoading" @click="saveSnapShot()">上传</el-button>
        </div>
      </div>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogPhotoVisible = false">关 闭</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { dataToFile } from '@/utils/index'
import { uploadApplyFiles } from '@/api/common'

export default {
  name: 'PhotoApply',
  data() {
    return {
      dialogPhotoVisible: false,
      videoWidth: 480,
      videoHeight: 360,
      imgSrc: "",
      thisCancas: null,
      thisContext: null,
      thisVideo: null,
      stream: null,
      src: '',
      listSrc: [],
      takePhoto: true,
      cameraShow: false,
      saveLoading: false,
      noShow: false,
      loadingText: '正在加载摄像头...',
      loadingErrorText: '正在加载摄像头...'
    }
  },
  props: {
    title: {
      type: String
    }
  },
  watch: {
    dialogPhotoVisible(val) {
      if (val) {
        this.$nextTick(() => {
          this.open()
        })
      } else {
        this.listSrc = []
        this.close()
      }
    }
  },
  beforeDestroy() {
    this.listSrc = []
  },
  mounted() {
  },
  methods: {
    getSrcList(index){
      const srcs = this.listSrc.map((v) => { return v.src })
      return srcs.slice(index).concat(srcs.slice(0,index))
    },
    takeSnapShot() {
      const _this = this
      const timestamp = new Date().getTime()
      const fileName = _this.applyID + '_' + timestamp
      // canvas画图
      _this.thisContext.drawImage(
          _this.thisVideo,
          0,
          0,
          _this.videoWidth,
          _this.videoHeight
      );
      // 获取图片base64链接
      const image = _this.thisCancas.toDataURL("image/jpeg");
      _this.src = image
      _this.listSrc.push({
        src: _this.src,
        file: dataToFile(_this.src, fileName),
        title: fileName
      })

      _this.takePhoto = false
    },
    delClick(src) {
      this.listSrc = this.listSrc.filter((v) => {return src.src !== v.src})
    },
    againTakePhoto() {
      this.src = ''
      this.listSrc = []
    },
    saveSnapShot() {
      if (this.listSrc.length === 0) {
        this.$message.warning('请上传相关数据')
        return
      }
      // 拍照
      const _this = this
      // 调用后台接口
      _this.saveLoading = true
      _this.loadingText = '正在上传图片，请稍后...'
      let formData = new FormData()
      _this.listSrc.forEach((v) => {
        formData.append("images", v.file)
      })
      // 上传自己可以自己写
      uploadApplyFiles(formData).then(res => {
        // const data = res.message
        _this.$message.success('上传图片成功')
        _this.dialogPhotoVisible = false
      }).catch(() => {
        setTimeout(() => {
          // 失败
          _this.src = ''
          _this.saveLoading = false
          _this.takePhoto = true
          _this.cameraShow = true
        }, 500)
      })
    },
    close() {
      this.src = ''
      this.listSrc = []
      this.saveLoading = false
      this.cameraShow = false
      this.takePhoto = true
      this.loadingText = '正在关闭摄像头...'
      this.stopNavigator()
    },
    open() {
      this.cameraShow = false
      this.loadingText = '正在打开摄像头...'

      this.getCompetence()
      setTimeout(() => {
        this.cameraShow = true
      }, 1500)
    },
    // 调用权限（打开摄像头功能）
    getCompetence() {
      const _this = this;
      _this.thisCancas = document.getElementById("canvasCamera");
      _this.thisContext = this.thisCancas.getContext("2d");
      _this.thisVideo = document.getElementById("videoCamera");
      _this.thisVideo.style.display = 'block';
      // 获取媒体属性，旧版本浏览器可能不支持mediaDevices，我们首先设置一个空对象
      if (navigator.mediaDevices === undefined) {
        navigator.mediaDevices = {};
      }
      // 一些浏览器实现了部分mediaDevices，我们不能只分配一个对象
      // 使用getUserMedia，因为它会覆盖现有的属性。
      // 这里，如果缺少getUserMedia属性，就添加它。
      if (navigator.mediaDevices.getUserMedia === undefined) {
        navigator.mediaDevices.getUserMedia = function(constraints) {
          // 首先获取现存的getUserMedia(如果存在)
          const getUserMedia =
              navigator.webkitGetUserMedia ||
              navigator.mozGetUserMedia ||
              navigator.getUserMedia;
          // 有些浏览器不支持，会返回错误信息
          // 保持接口一致
          if (!getUserMedia) {//不存在则报错
            return Promise.reject(
                _this.$message.error("浏览器没有打开摄像头的权限！")
            );
          }
          // 否则，使用Promise将调用包装到旧的navigator.getUserMedia
          return new Promise(function(resolve, reject) {
            getUserMedia.call(navigator, constraints, resolve, reject);
          });
        };
      }
      let constraints = {
        audio: false,
        video: {
          width: this.videoWidth,
          height: this.videoHeight,
          transform: "scaleX(-1)"
        }
      };
      navigator.mediaDevices.getUserMedia(constraints).then(function(stream) {
        _this.stream = stream
        // 旧的浏览器可能没有srcObject
        if ("srcObject" in _this.thisVideo) {
          _this.thisVideo.srcObject = stream;
        } else {
          // 避免在新的浏览器中使用它，因为它正在被弃用。
          _this.thisVideo.src = window.URL.createObjectURL(stream);
        }
        _this.thisVideo.onloadedmetadata = function(e) {
          _this.thisVideo.play();
        };
      }).catch(err => {
        console.log(err);
        this.$nextTick(() => {
          this.noShow = true
          this.loadingErrorText = '浏览器没有打开摄像头的权限!在chrome浏览器的地址栏中输入: chrome://flags/#unsafely-treat-insecure-origin-as-secure，将该 flag 切换成 enable 状态；\n' +
              '在输入框中填写需要开启的域名或地址，如果有多个，则以逗号分隔；\n' +
              '重启浏览器后生效。'
        })
      });
    },
    // 关闭摄像头
    stopNavigator() {
      if (this.stream) {
        if (this.stream.getVideoTracks) {
          let tracks = this.stream.getVideoTracks();
          if (tracks && tracks[0] && tracks[0].stop) tracks[0].stop();
        } else if (this.stream.stop) {
          this.stream.stop();
        }
      }
    }
  }
}
</script>

<style scoped lang="scss">
.pictureBox {
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.btn-cn {
  width: 100%;
  text-align: center;
  margin-top: 20px;
  margin-bottom: 20px;
}

#my_camera {
  border: 1px solid #606266;
}

.picList{
  width: 200px;
  overflow-x: hidden;
  overflow-y: scroll;
  height: 360px;
  .el-image{
    width: 180px;
    height: 130px;
    margin: 0px 0px 10px 10px;
  }
}
.camera_no_data{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 50px;
  width: 100%;
  margin-bottom: 20px;
  background: #fff;
  height: 360px;
  border: 1px solid #606266;
  .el-icon-loading {
    font-size: 40px;
  }
  .text {
    font-size: 20px;
    margin-top: 30px;
  }
}
.camera_no {
  position: relative;
  background: #fff;
  width: 480px;
  height: 360px;
  border: 1px solid #606266;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;

  .el-icon-loading {
    font-size: 40px;
  }

  .text {
    font-size: 20px;
    margin-top: 30px;
  }
}
::v-deep .el-image-viewer__mask {
  opacity: .9;
  background: #fff;
}
.el-icon-error{
  position: absolute;
  right: 0;
  top: 0;
  font-size: 25px;
  color: yellow;
  cursor: pointer;
}
</style>