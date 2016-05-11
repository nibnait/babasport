package com.nibnait.babasport.common.captcha;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CreateCaptcha {

    private final static int width = 120;
    private final static int height = 40;
    private final static Random rand = new Random();
    private final static int BUGNUM = 40;				//噪点数量
    private final static int LINENUM = 0;				//干扰线的数量
    private final static int FontNum = 28;				//字体大小
    private final static int startX = 2;
    private final static int startY = 30;
    private static Color backColor = Color.white;

    /**
     * 绘制验证码
     * @param s 验证码字符串
     * @return 绘制的验证码图片
     */
    public static BufferedImage getCaptcha(String s){
        BufferedImage bImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bImg.getGraphics();
        backColor = backColor();
        g.setColor(backColor);
        Color reColor = reColor(g.getColor());
        g.setFont(new Font(null, Font.BOLD, FontNum));
        g.fillRect(0, 0, width, height);
        g.setColor(reColor);
        drawFont(g, s);
        drawBug(g);
        drawLines(g);
        g.dispose();
        return SinWaveFilter(bImg);
    }
    //绘制验证码字符串
    private static void drawFont(Graphics2D g, String s) {
        int nowX = FontNum - 6;
        double degree = 0;
        g.translate(startX , startY);
        for(int i = 0; i < s.length(); i++){
            degree = (rand.nextInt(90) - 45)* Math.PI / 180;
            g.translate(nowX , 0);
            g.rotate(degree );
            g.drawString(s.charAt(i)+"", 0, 0);
            g.rotate(-degree);
        }
        g.translate(-nowX * s.length() - startX, -startY);
    }

    //图片扭曲滤镜
    private static BufferedImage SinWaveFilter(BufferedImage img){
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage outImg = new BufferedImage(w, h, img.getType());
        Graphics g = outImg.getGraphics();
        g.setColor(backColor);
        g.fillRect(0, 0, w, h);
        g.dispose();
        //幅度倍数
        double x = rand.nextInt(4)+4;		/////////////////////////////////////////
        //初始相位  0-2pi
        double start = rand.nextInt(6);

        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                int oldY = (int) (j + Math.sin((double)(Math.PI * i / h + start)) * x);
                if(oldY >= 0 && oldY < h){
                    outImg.setRGB(i, oldY, img.getRGB(i, j));
                }
            }
        }
        return outImg;
    }
    //绘制背景色
    private static Color backColor(){
//        return new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));
        return new Color(222,222,222);
    }
    //背景色的反色
    private static Color reColor(Color color){
        return new Color(255 - color.getRed(), 255 - color.getGreen(), 255 - color.getBlue());
    }
    //绘制噪点
    private static void drawBug(Graphics g){
        for (int i = 0; i < BUGNUM; i++) {
            //g.setColor(backColor());
            g.drawRect(rand.nextInt(width), rand.nextInt(height), 1, 1);
        }
    }
    //绘制干扰线
    private static void drawLines(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setStroke(new BasicStroke(2));
        for (int i = 0; i < LINENUM; i++) {
            g2d.drawLine(rand.nextInt(30), rand.nextInt(height/2)+height/2, rand.nextInt(width/2)+width/2,rand.nextInt(height));
        }
    }
}
