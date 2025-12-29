package edu.cjc.sms.app.controller;

import java.util.List;

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
			List<Student> list = ssi.getAllStudent();
			m.addAttribute("data", list);
			return "adminscreen";
		}
		else {
				m.addAttribute("login_fail","Enter valid username and password.");
				return "login";
		}
	}
	
	@RequestMapping("/enroll_student")
	public String saveStudentDetails(@ModelAttribute Student s ,Model m)
	{
		
		ssi.saveStudentData(s);
		List<Student> list = ssi.getAllStudent();
		m.addAttribute("data", list);
		return "adminscreen";
		
	}
	
	@RequestMapping("/delete")
	public String removeStudent(@RequestParam("rollno") int rollno,Model m ) {
		
		ssi.deleteStudent(rollno);
		List<Student> list = ssi.getAllStudent();
		m.addAttribute("data", list);
		return "adminscreen";
		
	}
	
	@RequestMapping("/search")
	public String getStudentBatch(@RequestParam("batchNumber") String batchNumber,Model m) {
		
		List<Student> result=ssi.searchStudentByBatch(batchNumber);
		if(result.size()>0)
		{
			m.addAttribute("data",result);
		}
		else {
				List<Student> list = ssi.getAllStudent();
				m.addAttribute("data", list);
				m.addAttribute("message","No record found for the Batch "+batchNumber);
				
		}
		

		return "adminscreen";
		
	}
	
	
	
	
}
