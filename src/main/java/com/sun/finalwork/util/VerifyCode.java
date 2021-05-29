package com.sun.finalwork.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCode {

    public static String drawRandomText(int width, int height, BufferedImage verifyImg){
        Graphics2D graphics = (Graphics2D)verifyImg.getGraphics();
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,width,height);
        graphics.setFont(new Font("微软雅黑",Font.BOLD,40));
        String baseNumLetter = "123456789abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
        StringBuffer sBuffer = new StringBuffer();
        int x = 10;  //旋转原点的 x 坐标

        String ch = "";

        Random random = new Random();

        for(int i = 0;i < 4;i++){

            graphics.setColor(getRandomColor());

            //设置字体旋转角度

            int degree = random.nextInt() % 30;  //角度小于30度

            int dot = random.nextInt(baseNumLetter.length());

            ch = baseNumLetter.charAt(dot) + "";

            sBuffer.append(ch);

            //正向旋转

            graphics.rotate(degree * Math.PI / 180, x, 45);

            graphics.drawString(ch, x, 45);

            //反向旋转

            graphics.rotate(-degree * Math.PI / 180, x, 45);

            x += 48;

        }
        for (int i = 0; i <6; i++) {

            // 设置随机颜色

            graphics.setColor(getRandomColor());

            // 随机画线

            graphics.drawLine(random.nextInt(width), random.nextInt(height),

                    random.nextInt(width), random.nextInt(height));

        }

        //添加噪点

        for(int i=0;i<30;i++){

            int x1 = random.nextInt(width);

            int y1 = random.nextInt(height);

            graphics.setColor(getRandomColor());

            graphics.fillRect(x1, y1, 2,2);

        }

        return sBuffer.toString();
    }

    private static Color getRandomColor() {

        Random ran = new Random();

        Color color = new Color(ran.nextInt(256),

                ran.nextInt(256), ran.nextInt(256));

        return color;

    }
}
