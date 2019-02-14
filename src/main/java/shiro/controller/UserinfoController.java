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
	public void test() {
		System.out.println("hello world");
	}
	public void test1() {
		System.out.println("hello world1");
	}
}
