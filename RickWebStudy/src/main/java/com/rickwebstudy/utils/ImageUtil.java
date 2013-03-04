package com.rickwebstudy.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class ImageUtil {
	
	private static boolean writeHighQuality(BufferedImage im, String savePath) {
        try {
            /*输出到文件流*/
            FileOutputStream newimage = new FileOutputStream(savePath);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(newimage);
            JPEGEncodeParam jep = JPEGCodec.getDefaultJPEGEncodeParam(im);
            /* 压缩质量 */
            jep.setQuality(1f, true);
            encoder.encode(im, jep);
           /*近JPEG编码*/
            newimage.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
	/**
     * @param im            原始图像
     * @param resizeTimes   倍数,比如0.5就是缩小一半,0.98等等double类型
     * @return              返回处理后的图像
     */
	private static BufferedImage zoomImage(BufferedImage im, float resizeTimes) {
        /*原始图像的宽度和高度*/
        int width = im.getWidth();
        int height = im.getHeight();

        /*调整后的图片的宽度和高度*/
        int toWidth = (int) (Float.parseFloat(String.valueOf(width)) * resizeTimes);
        int toHeight = (int) (Float.parseFloat(String.valueOf(height)) * resizeTimes);

        /*新生成结果图片*/
        BufferedImage result = new BufferedImage(toWidth, toHeight, BufferedImage.TYPE_INT_RGB);

        result.getGraphics().drawImage(im.getScaledInstance(toWidth, toHeight, java.awt.Image.SCALE_SMOOTH), 0, 0, null);
        return result;
    }
	
    private static BufferedImage getBufferedImageFile(String path){
    	BufferedImage bufferedImage = null;
    	try {
    		File file = new File(path);
    		bufferedImage = javax.imageio.ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return bufferedImage;
    }
    

    public static void createThumbnailImage(float times, String sourcePath, String targetPath){
        writeHighQuality(zoomImage(getBufferedImageFile(sourcePath),times), targetPath);
    }
}
