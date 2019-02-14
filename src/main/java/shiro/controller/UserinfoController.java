package shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserinfoController {
	
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	
	@RequestMapping("login")
	public String login(){
		
		return "UserList";
	}
}
