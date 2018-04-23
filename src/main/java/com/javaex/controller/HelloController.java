package com.javaex.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.vo.UserVO;

//서블릿 상속이 필요없다.
//어노테이션 쓰고 ctrl+shift+o
@Controller
public class HelloController {
	
	@RequestMapping( "/hello")
	public String hello(){
		System.out.println("/hellospring/hello");
		return "/WEB-INF/views/index.jsp";
	}

	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String main() {
		System.out.println("main");
		return "/WEB-INF/views/index.jsp";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.GET)
	public String form() {

		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	//이제 받아와야됩니다. form에서 입력한 값을 
	public String add(@RequestParam("age")int age, @RequestParam("name")String name) {
		System.out.println(age);
		System.out.println(name);
		
		return "";
	}
	
	@RequestMapping(value="/add2",method=RequestMethod.GET)
	//이제 받아와야됩니다. form에서 입력한 값을 
	public String add2(@ModelAttribute UserVO uservo) {
		System.out.println(uservo.toString());
		return "";
	}
	
	@RequestMapping(value="/read/{no}",method=RequestMethod.GET)
	public String read(@PathVariable("no")int no) {
		System.out.println(no+"번글 가져오기");
		return "";
	}
	
	@RequestMapping(value="add3")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		//상속받았으니 예전과 같이 쓸 수 있다. 근데 가급적 이렇게 안하는게 낫다. dispacherServlet이 하도록 두는게 낫다.
		String name =request.getParameter("name");
		System.out.println(name);
		return "";
		
	}
	
	@RequestMapping(value="/userlist")
	public String list(Model model) {
		//DB로 아직 못가져와서 강제로 넣고 있다.
		ArrayList<UserVO> userlist = new ArrayList<UserVO>();
		UserVO user01 = new UserVO(11,"유재석");
		UserVO user02 = new UserVO(22,"정준하");
		UserVO user03 = new UserVO(33,"박명수");
		
		userlist.add(user01);
		userlist.add(user02);
		userlist.add(user03);
		System.out.println(userlist.toString());
		
		model.addAttribute("userList",userlist);
		
		
		return "/WEB-INF/views/index.jsp";
	}

}
