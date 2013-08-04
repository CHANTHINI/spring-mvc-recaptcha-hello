package com.srccodes.spring.controller;

import javax.servlet.ServletRequest;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Abhijit Ghosh
 * @version 1.0
 */
@Controller
public class ReCaptchaHelloWorldController {
	@Autowired
	private ReCaptcha reCaptchaService = null;
	
	
	@RequestMapping(value={"/", "/recaptcha"},  method=RequestMethod.GET)
	public String show() {	
		return "captcha";
	}
	
	@RequestMapping(value="/recaptcha", method=RequestMethod.POST)
	public String verify(ServletRequest request, Model model) {	
		String challenge = request.getParameter("recaptcha_challenge_field");
		String response = request.getParameter("recaptcha_response_field");
		String remoteAddr = request.getRemoteAddr();
		
		ReCaptchaResponse reCaptchaResponse = reCaptchaService.checkAnswer(remoteAddr, challenge, response);
		
		if(reCaptchaResponse.isValid()) {
			model.addAttribute("message", "reCaptcha Hello World!");
			return "success";
		} else {
			model.addAttribute("message", "Try again and prove it.");
			return "captcha";
		}
	}

}
