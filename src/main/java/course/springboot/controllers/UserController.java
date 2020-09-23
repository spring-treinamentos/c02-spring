package course.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import course.springboot.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	public String getUsers(Model model) {
		
		model.addAttribute("usersList", this.userService.listAllUsers());
		
		return "user";
	}
	
		
}
