package com.newbee.material.repo.controller;

import com.newbee.material.repo.api.IUserService;
import com.newbee.material.repo.domain.User;
import com.newbee.material.repo.util.common.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam("loginname") String loginName,
			@RequestParam("password") String password, HttpSession session,
			ModelAndView modelAndView) {
		User user = userService.getUser(loginName);
		if (null != user) {
			String realPwd = user.getPassword();
			if (null == realPwd || "".equals(realPwd)) {
				session.setAttribute(Constants.USER_SESSION, user);
				modelAndView.setViewName("redirect:/main");
			} else if (realPwd.equals(password)) {
				session.setAttribute(Constants.USER_SESSION, user);
				modelAndView.setViewName("redirect:/main");
			} else {
				modelAndView.addObject("message", "登录名或密码错误！请重新输入");
				modelAndView.setViewName("forward:/loginForm");
			}
		} else {
			modelAndView.addObject("message", "登录名或密码错误！请重新输入");
			modelAndView.setViewName("forward:/loginForm");
		}

		return modelAndView;
	}
}
