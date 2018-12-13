package com.niit.EComFront.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
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

 @RequestMapping("/register")
 public String registerpage(Model M) {
	 M.addAttribute("registerpage",true);
	 return "index";
 }
}
