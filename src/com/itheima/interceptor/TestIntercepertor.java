package com.itheima.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class TestIntercepertor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		String username = (String) request.getSession()
				.getAttribute("username");

		if (username != null) {

			return arg0.invoke();
		} else {

			return Action.LOGIN;
		}

	}

}
