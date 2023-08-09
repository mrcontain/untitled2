//package com.me.utils;
//
//import org.junit.Test;
//
//
//import org.junit.Test;
//import org.opencv.core.*;
//import org.opencv.highgui.HighGui;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.objdetect.CascadeClassifier;
//import javax.swing.*;
//import org.opencv.core.Point;
//import org.opencv.core.*;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.objdetect.CascadeClassifier;
//import org.opencv.videoio.VideoCapture;
//import org.opencv.videoio.Videoio;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.util.Arrays;
//import java.util.UUID;
//
//public class FaceCompareUtils {
//    static int i=1;
//    @Test
//    public void test(){
//        //System.out.println(imageFaceDetection());
//        //String x=imageFaceDetection("C:\\Users\\frank\\Desktop\\test2.png");//库中保存的图片截取人脸部分
//        //String y=imageFaceDetection("C:\\Users\\frank\\Desktop\\compare\\R-C.png");//摄像头拍摄的图片截取人脸部分
//        //System.out.println(x);
//        //System.out.println(y);
//        //String x="C:\\Users\\frank\\Desktop\\test2\\1.png";
//        //String y="C:\\Users\\frank\\Desktop\\test2\\2.png";
//        System.out.println(faceRecognitionComparison("C:\\testx\\testx.png", "C:\\testy\\testy.png"));
//        //String y="C:\\Users\\frank\\Desktop\\compare\\R-C.png";
//        //imageFaceDetection();
//        //double z=faceRecognitionComparison(x,y);
//        //System.out.println(compare(x,y));
//        //System.out.println(z);
//    }
//    /*
//    public static void main(String[] args) {
//        imageFaceDetection();
//    }*/
//
//
//    /**
//     * 图片人脸检测
//     */
//
//    public static String imageFaceDetection(String imgPath) {
//        // 加载OpenCV本地库
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        // 从配置文件lbpcascade_frontalface.xml中创建一个人脸识别器，文件位于opencv安装目录中
//        CascadeClassifier faceDetector = new CascadeClassifier("D:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
//        // 读取测试图片
//        //String imgPath = "C:\\Users\\frank\\Desktop\\test2.png";
//        Mat image = Imgcodecs.imread(imgPath);
//        if (image.empty()) {
//            throw new RuntimeException("图片内存为空");
//        }
//
//        // 检测脸部
//        MatOfRect face = new MatOfRect();
//        // 检测图像中的人脸
//        faceDetector.detectMultiScale(image, face);
//        // 匹配Rect矩阵
//        Rect[] rects = face.toArray();
//        //System.out.println("识别人脸个数： " + rects.length);
//
//        // 识别图片中的所有人脸并分别保存
//        String path="0";
//        //int i = 1;
//        for (Rect rect : face.toArray()) {
//            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0), 3);
//            // 进行图片裁剪
//            path=imageCut(imgPath, "C:\\test2\\" + i + ".png", rect.x, rect.y, rect.width, rect.height);
//            i++;
//        }
//        // 图片中人脸画框保存到本地
//        //Imgcodecs.imwrite("C:\\Users\\frank\\Desktop\\test2\\test2.png", image);
//
//        // 展示图片
//        //HighGui.imshow("人脸识别", image);
//        //HighGui.waitKey(0);
//        //return "C:\\Users\\frank\\Desktop\\test2\\" + i + ".jpg";
//        return path;
//    }
//
//    /**
//     * 裁剪人脸
//     *
//     */
//    public static String imageCut(String readPath, String outPath, int x, int y, int width, int height) {
//        // 原始图像
//        Mat image = Imgcodecs.imread(readPath);
//        // 截取的区域
//        Rect rect = new Rect(x, y, width, height);
//        // Mat sub = new Mat(image,rect);
//        Mat sub = image.submat(rect);
//        Mat mat = new Mat();
//        Size size = new Size(width, height);
//        // 人脸进行截图并保存
//        Imgproc.resize(sub, mat, size);
//        Imgcodecs.imwrite(outPath, mat);
//        return outPath;
//    }
//
//    // 初始化人脸探测器
//    static CascadeClassifier faceDetector;
//
//    static {
//        // 加载OpenCV本地库
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        // 从配置文件lbpcascade_frontalface.xml中创建一个人脸识别器，文件位于opencv安装目录中
//        faceDetector = new CascadeClassifier("D:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
//    }
//
//
//    /*
//    public static void main(String[] args) {
//        double comparison = faceRecognitionComparison("D:\\user\\1.jpg", "D:\\user\\1-1.jpg");
//        System.out.println("对比结果：" + comparison);
//        if (comparison > 0.85) {
//            System.out.println("人脸匹配成功");
//        } else {
//            System.out.println("人脸不匹配识别");
//        }
//
//        double comparison2 = faceRecognitionComparison("D:\\user\\1.jpg", "D:\\user\\3.jpg");
//        System.out.println("对比结果：" + comparison2);
//        if (comparison2 > 0.85) {
//            System.out.println("人脸匹配成功");
//        } else {
//            System.out.println("人脸不匹配识别");
//        }
//        // 终止当前运行的 Java 虚拟机。
//        System.exit(0);
//    }
//     */
//
//
//    /**
//     * 人脸识别比对
//     */
//    public static double faceRecognitionComparison(String image1, String image2) {
//        Mat mat1 = conv_Mat(image1);
//        Mat mat2 = conv_Mat(image2);
//        Mat mat3 = new Mat();
//        Mat mat4 = new Mat();
//        // 颜色范围
//        MatOfFloat ranges = new MatOfFloat(0f, 256f);
//        // 直方图大小， 越大匹配越精确 (越慢)
//        MatOfInt histSize = new MatOfInt(1000);
//        Imgproc.calcHist(Arrays.asList(mat1), new MatOfInt(0), new Mat(), mat3, histSize, ranges);
//        Imgproc.calcHist(Arrays.asList(mat2), new MatOfInt(0), new Mat(), mat4, histSize, ranges);
//
//        // 比较两个密集或两个稀疏直方图
//        return Imgproc.compareHist(mat3, mat4, Imgproc.CV_COMP_CORREL);
//    }
//
//    public static boolean compare(String x,String y)//x、y为base64编码
//    {
//        String xPath="C:\\testx\\testx.png";//base64转换成的图片的路径
//        String yPath="C:\\testy\\testy.png";
//        Base64TransWithImg a=new Base64TransWithImg();
//        a.convertBase64StrToImage(x,xPath);//调用base64转图片函数
//        a.convertBase64StrToImage(y,yPath);
//        //imageFaceDetection(xPath);//切割后图片路径
////        System.out.println(imageFaceDetection(xPath));
////        String s = imageFaceDetection(xPath);
////        String s1 = imageFaceDetection(yPath);
//
//        double result=faceRecognitionComparison(xPath,yPath);
//        System.out.println(result);
//        if(result>=0.90)
//            return true;
//        else
//            return false;
//    }
//    /**
//     * 灰度化人脸
//     */
//    public static Mat conv_Mat(String img) {
//        // 读取图像
//        Mat mat1 = Imgcodecs.imread(img);
//        Mat mat2 = new Mat();
//        // 灰度化:将图像从一种颜色空间转换为另一种颜色空间
//        Imgproc.cvtColor(mat1, mat2, Imgproc.COLOR_BGR2GRAY);
//        // 探测人脸:检测到的对象作为矩形列表返回
//        MatOfRect faceDetections = new MatOfRect();
//        faceDetector.detectMultiScale(mat1, faceDetections);
//        // rect中人脸图片的范围
//        for (Rect rect : faceDetections.toArray()) {
//            Mat face = new Mat(mat1, rect);
//            return face;
//        }
//        return null;
//    }
//
//    // 初始化人脸探测器
//
//    static {
//        // 加载OpenCV本地库
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        // 从配置文件lbpcascade_frontalface.xml中创建一个人脸识别器，文件位于opencv安装目录中
//        faceDetector = new CascadeClassifier("D:\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
//    }
//
//}