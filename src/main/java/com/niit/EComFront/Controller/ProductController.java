package com.niit.EComFront.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.EComBack.DAO.ProductDAO;
import com.niit.EComBack.Model.Category;
import com.niit.EComBack.Model.Product;

public class ProductController {
	@Autowired
	 ProductDAO pd;
	 @RequestMapping("/product")
	 public String productpage(Model M) {
		 M.addAttribute("product",new Product());
		 M.addAttribute("prodlist",pd.SelectAllProduct());

		 M.addAttribute("productpage",true);
		 M.addAttribute("haserror",false);
		 return "index";
	 }
		@RequestMapping(value="productadd",method= RequestMethod.POST)
		public String AddCategory (@Valid @ModelAttribute("Product")Product product,BindingResult result,Model M)
		{
			if(result.hasErrors())
			{
				M.addAttribute("product", product);
				M.addAttribute("productpage",true);
				M.addAttribute("haserror", true);
				M.addAttribute("error", "pls check ur data");
				return "index";
			
			}
			else {
				try {
					pd.CreateProduct(product);
					
					
					return "redirect:/";
				} 
				catch (Exception e) {
					M.addAttribute("Product", product);
					M.addAttribute("productpage",true);
					M.addAttribute("haserror", true);
					M.addAttribute("error", "Data Already Present");
					return "index";
					
				}
		
			}
		
			
		}
		
		@RequestMapping("/deleteproduct")
		public String deletecategory(@RequestParam ("product_id")int product_id)
		{
			Product p=pd.SelectProduct(product_id);
		
		pd.DeleteProduct(p);
		return "redirect:/product";
		}
		
		
	}


