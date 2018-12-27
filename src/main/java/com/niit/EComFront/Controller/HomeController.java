package com.niit.EComFront.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
 @RequestMapping({"/","/home"})
 public String indexpage(Model M) {
	 M.addAttribute("sliderpage",true);
	 return "index";
	}
 @RequestMapping("/aboutus")
 public String aboutpage(Model M) {
	 M.addAttribute("aboutpage",true);
	 return "index";
 }
 @RequestMapping("/contactus")
 public String contactpage(Model M) {
	 M.addAttribute("contactpage",true);
	 return "index";
	 
 }

 @RequestMapping("/Login")
 public String loginpage(Model M) {
	 M.addAttribute("Loginpage",true);
	 M.addAttribute("error",false);
	 M.addAttribute("message","");
	 return "index";
 }
 @RequestMapping("/flogin")
 public String floginpage(Model M) {
	 M.addAttribute("fLoginpage",true);
	 M.addAttribute("error",true);
	 M.addAttribute("message","user name ,password incorrect");
	 return "index";
 }

 
}
