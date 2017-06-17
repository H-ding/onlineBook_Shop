package com.itheima.action;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.itheima.dao.Impl.VerificationCodeUtildaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;

public class VerificationCodeUtilAction extends StrutsResultSupport {
	private ByteArrayInputStream inputStream;
	private BufferedImage image;

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	@Override
	protected void doExecute(String arg0, ActionInvocation arg1)
			throws Exception {
		// TODO Auto-generated method stub
		VerificationCodeUtildaoImpl vcu = new VerificationCodeUtildaoImpl();
		BufferedImage image1 = vcu.getImage1();
		this.setImage(image1);
		HttpServletResponse response = ServletActionContext.getResponse();
		ImageIO.write(image1, "jpeg", response.getOutputStream());
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("random",
				vcu.getVerificationCodeValue());
		System.out.println("当前的验证码值是:" + vcu.getVerificationCodeValue());
	}

}
