package com.niit.EComFront.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.EComBack.DAO.UserDAO;
import com.niit.EComBack.Model.UserDetails;

@Controller
public class logincontroller {
	@Autowired
	UserDAO ud;

	@RequestMapping({ "/register" })
	public String registerpage(Model m) {
		m.addAttribute("registerpage", true);
		m.addAttribute("UserDetails", new UserDetails());
		m.addAttribute("haserror", false);
		return "index";
	}

	@RequestMapping(value = "/CreateUserDetails", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("UserDetails") UserDetails userDetail, BindingResult br,
			Model m) {
		if (br.hasErrors()) {

			m.addAttribute("UserDetails", userDetail);
			m.addAttribute("registerpage", true);
			m.addAttribute("haserror", true);
			m.addAttribute("error", "please check ur data");
			return "index";
		} else {
			try {
				ud.createUser(userDetail);
				return "redirect:/register";
			} catch (Exception e) {

				m.addAttribute("UserDetails", userDetail);
				m.addAttribute("registerpage", true);
				m.addAttribute("haserror", true);
				m.addAttribute("error", "Already Data Present");
				return "index";
			}
		}

	}
}
