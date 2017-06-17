package com.itheima.dao.Impl;

import com.itheima.dao.VerificationCodeUtildao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class VerificationCodeUtildaoImpl implements VerificationCodeUtildao {
	private String str;// 字符串生成
	private static final int WIDTH = 80;
	private static final int HEIGHT = 20;
	private BufferedImage image1;

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public VerificationCodeUtildaoImpl() {
		BufferedImage image1 = new BufferedImage(WIDTH, HEIGHT,
				BufferedImage.TYPE_INT_RGB);
		this.image1 = image1;
		initNumVerificationCode(image1);
	}

	private void initNumVerificationCode(BufferedImage image) {
		// TODO Auto-generated method stub
		Random random = new Random();
		Graphics g = initImage(image, random);
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将验证码显示到图像中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			//  生成图片
			g.drawString(rand, 13 * i + 6, 16);
		}
		this.setStr(sRand);// 验证码赋值
		// 图像生效
		g.dispose();
	}

	private Graphics initImage(BufferedImage image, Random random) {
		// TODO Auto-generated method stub
		Graphics g = image.getGraphics();// 获取图形上下文
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 14));//  设定字体
		return g;
	}

	/**
	 *        功能：获取验证码的字符串值       
	 */
	public String getVerificationCodeValue() {
		return this.getStr();
	}

	/**
	 *        * 功能：取得验证码图片       * @return       
	 */
	public BufferedImage getImage1() {
		return this.image1;
	}
}