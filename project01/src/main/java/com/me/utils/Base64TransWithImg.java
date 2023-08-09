package com.me.utils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Base64TransWithImg {

        @Test
        public void test(){
            String base64String="hello";
            base64String = convertImageToBase64Str("C:\\ccc\\image0.png");
            System.out.println(base64String);
            //找不到这个的文件路径，你试试网上的图片的url路径，本地路径的化可能是在我的电脑里找，好像是只能输入本地的地，url地址似乎不太行，他这个方法里好像默认是本地的文件地址。
//            convertBase64StrToImage(base64String, "https://cn.bing.com/images/search?view=detailV2&ccid=UkOLRmLj&id=BEC994A859C8B3BE5D419C1E03EF4E2478CB2500&thid=OIP.UkOLRmLjyzm1OIsrOupuBwHaFj&mediaurl=https%3a%2f%2fimg.mianfeiwendang.com%2fpic%2fb99ae32af120fa2849a06f37%2f1-1134-jpg_6-1512-0-0-1512.jpg&exph=1134&expw=1512&q=%e5%9b%be&simid=608006969735406414&FORM=IRPRST&ck=E7317DED4F019208B682D55386493799&selectedIndex=0&ajaxhist=0&ajaxserp=0");
            //should at least have 2 bytes for base64 bytes应该至少需要两个字节的数据
        }
        /**
         * 图片转Base64字符串
         * @param imageFileName
         * @return
         */
        public static String convertImageToBase64Str(String imageFileName) {
            ByteArrayOutputStream baos = null;
            try {
                //获取图片类型
                String suffix = imageFileName.substring(imageFileName.lastIndexOf(".") + 1);
                //构建文件
                File imageFile = new File(imageFileName);
                //通过ImageIO把文件读取成BufferedImage对象
                BufferedImage bufferedImage = ImageIO.read(imageFile);
                //构建字节数组输出流
                baos = new ByteArrayOutputStream();
                //写入流
                ImageIO.write(bufferedImage, suffix, baos);
                //通过字节数组流获取字节数组
                byte[] bytes = baos.toByteArray();
                //获取JDK8里的编码器Base64.Encoder转为base64字符
                return Base64.getEncoder().encodeToString(bytes);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (baos != null) {
                        baos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        /**
         * Base64字符串转图片
         * @param base64String
         * @param imageFileName
         */
        public static void convertBase64StrToImage(String base64String, String imageFileName) {
            ByteArrayInputStream bais = null;
            try {
                //获取图片类型
                String suffix = imageFileName.substring(imageFileName.lastIndexOf(".") + 1);
                //获取JDK8里的解码器Base64.Decoder,将base64字符串转为字节数组
                byte[] bytes = Base64.getDecoder().decode(base64String);
                //构建字节数组输入流
                bais = new ByteArrayInputStream(bytes);
                //通过ImageIO把字节数组输入流转为BufferedImage
                BufferedImage bufferedImage = ImageIO.read(bais);
                //构建文件
                File imageFile = new File(imageFileName);
                //写入生成文件
                ImageIO.write(bufferedImage, suffix, imageFile);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bais != null) {
                        bais.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
