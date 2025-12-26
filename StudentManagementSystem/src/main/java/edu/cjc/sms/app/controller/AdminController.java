package edu.cjc.sms.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cjc.sms.app.model.Student;
import edu.cjc.sms.app.servicei.StudentServiceI;

@Controller
public class AdminController {
	@Autowired
	StudentServiceI ssi;
	
	@RequestMapping("/")
	public String preLogin() {
	
		
		return "login";
		
	}
	@RequestMapping("/login")
	public String login(@RequestParam String username,@RequestParam  String password,Model m)
	{
		if(username.equals("admin") && password.equals("admin123"))
		{
			return "adminscreen";
		}
		else {
				m.addAttribute("login_fail","Enter valid username and password.");
				return "login";
		}
	}
	
	@RequestMapping("/enroll_student")
	public String saveStudentDetails(@ModelAttribute Student s)
	{
		
		ssi.saveStudentData(s);
		return "adminscreen";
		
	}
	
	
}
