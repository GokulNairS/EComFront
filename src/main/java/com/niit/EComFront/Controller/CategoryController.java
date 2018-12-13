	package com.niit.EComFront.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EComBack.DAO.CategoryDAO;
import com.niit.EComBack.Model.Category;

@Controller
public class CategoryController {
 @Autowired
 CategoryDAO cd;
 @RequestMapping("/category")
 public String categorypage(Model M) {
	 M.addAttribute("category",new Category());
	 M.addAttribute("catlist",cd.ViewAllCategory());

	 M.addAttribute("categorypage",true);
	 M.addAttribute("haserror",false);
	 M.addAttribute("editMode",false);
		 return "index";
 }
	@RequestMapping(value="categoryadd",method= RequestMethod.POST)
	public String AddCategory (@Valid @ModelAttribute("category")Category category,BindingResult result,Model M)
	{
		if(result.hasErrors())
		{
			M.addAttribute("catergory", category);
			M.addAttribute("categorypage",true);
			M.addAttribute("haserror", true);
			M.addAttribute("error", "pls check ur data");
			return "index";
		
		}
		else {
			try {
				cd.CreateCategory(category);
				
				
				return "redirect:/";
			} 
			catch (Exception e) {
				M.addAttribute("category", category);
				M.addAttribute("categorypage",true);
				M.addAttribute("haserror", true);
				M.addAttribute("error", "Data Already Present");
				return "index";
				
			}
	
		}
	
		
	}
	
	@RequestMapping("/deletecategory")
	public String deletecategory(@RequestParam ("category_id")int category_id,Model m)
	{
	Category c=cd.ViewOneCategory(category_id);
	cd.DeleteCategory(c);
	return "redirect:/category";
	}
	
	@RequestMapping("/editcategory")
	public String editcategory(@RequestParam ("category_id")int category_id,Model M) {
		M.addAttribute("editMode",true);
		M.addAttribute("category",cd.ViewOneCategory(category_id));
		M.addAttribute("categorypage",true);

		 M.addAttribute("catlist",cd.ViewAllCategory());
		M.addAttribute("haserror", true);
		M.addAttribute("error", "");
		return "index";
		
		
	}
	
	@RequestMapping(value="update",method= RequestMethod.POST)
	public String update (@Valid @ModelAttribute("category")Category category,BindingResult result,Model M)
	{
		if(result.hasErrors())
		{
			M.addAttribute("editMode",false);
			 M.addAttribute("catlist",cd.ViewAllCategory());

			M.addAttribute("catergory", category);
			M.addAttribute("categorypage",true);
			M.addAttribute("haserror", true);
			M.addAttribute("error", "pls check ur data");
			return "index";
		
		}
		else {
			try {
				cd.UpdateCategory(category);
				
				
				return "redirect:/";
			} 
			catch (Exception e) {

				M.addAttribute("editMode",false);
				 M.addAttribute("catlist",cd.ViewAllCategory());

				M.addAttribute("category", category);
				M.addAttribute("categorypage",true);
				M.addAttribute("haserror", true);
				M.addAttribute("error", "Data Already Present");
				return "index";
				
			}
	
		}
	
		
	}
	
}
