//package com.niit.EComFront.Controller;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import javax.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import com.niit.EComBack.DAO.cartDAO;
//import com.niit.EComBack.DAO.ProductDAO;
//import com.niit.EComBack.Model.Cart;
//import com.niit.EComBack.Model.Product;
//
//@Controller
//public class CartController {
//
//	@Autowired
//	cartDAO cartDAO;
//
//	@Autowired
//	ProductDAO productDAO;
//
//	@RequestMapping("addToCart")
//	String addToCart(@RequestParam("productName") String productName, HttpSession session, Model m) {
//		if (session.getAttribute("usercartid") != null) {
//			Product p = productDAO.getProduct(productName);
//			ArrayList<Cart> cartlist = (ArrayList<Cart>) cartDAO
//					.listCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
//			Iterator<Cart> cartiterator = cartlist.listIterator();
//			while (cartiterator.hasNext()) {
//				System.out.println("1");
//				Cart cart2 = (Cart) cartiterator.next();
//				if (cart2.getPname().equals(productName)) {
//					System.out.println("2");
//					int qty = cart2.getQuantity() + 1;
//					if (qty > p.getQuantity()) {
//						m.addAttribute("cartpage", true);
//						m.addAttribute("cartlist", cartDAO.listCart(cart2.getCartid()));
//						m.addAttribute("error1", true);
//						m.addAttribute("error", false);
//						m.addAttribute("stock", p.getQuantity());
//						m.addAttribute("pid", cart2.getPid());
//						return "index";
//
//					} else {
//						System.out.println("3");
//						if (qty > 3) {
//							m.addAttribute("cartpage", true);
//							m.addAttribute("cartlist", cartDAO.listCart(cart2.getCartid()));
//							m.addAttribute("error", true);
//							m.addAttribute("error1", false);
//							m.addAttribute("pid", cart2.getPid());
//							return "index";
//						}
//						cart2.setQuantity(qty);
//						cart2.setSubTot(qty * p.getPrice());
//						cartDAO.update(cart2);
//						m.addAttribute("cartpage", true);
//						m.addAttribute("cartlist", cartDAO.listCart(cart2.getCartid()));
//						m.addAttribute("error", false);
//						m.addAttribute("error1", false);
//						return "index";
//					}
//
//				}
//			}
//			System.out.println("4");
//			Cart c = new Cart();
//			c.setCartid(Integer.parseInt(session.getAttribute("usercartid").toString()));
//			c.setPid(p.getProductId());
//			c.setQuantity(1);
//			c.setPname(p.getProductName());
//			c.setPrice(p.getPrice());
//			c.setSubTot(p.getPrice());
//			cartDAO.add(c);
//			m.addAttribute("cartpage", true);
//			m.addAttribute("cartlist", cartDAO.listCart(c.getCartid()));
//			m.addAttribute("error", false);
//			m.addAttribute("error1", false);
//			return "index";
//
//		} else {
//			session.setAttribute("proname", productName);
//			return "redirect:/Login";
//		}
//
//	}
//
//	@RequestMapping("/user/viewCart")
//	String viewCart(Model m, HttpSession session) {
//		int cartid = Integer.parseInt(session.getAttribute("usercartid").toString());
//		m.addAttribute("cartpage", true);
//		m.addAttribute("title", "Flower Paradise-MyCart");
//		m.addAttribute("cartlist", cartDAO.listCart(cartid));
//		m.addAttribute("error", false);
//		m.addAttribute("error1", false);
//		return "index";
//	}
//
//	@RequestMapping("/user/deleteitem")
//	public String deleteCart(@RequestParam("itemid") int tId) {
//	cartDAO.delete(cartDAO.getCart(tId));
//	return "redirect:/user/viewCart";
//	}
//
//	@RequestMapping("/user/incqty")
//	public String incqty(@RequestParam("itemid") int id, Model m) {
//		Cart c = cartDAO.getCart(id);
//		int qty = c.getQuantity() + 1;
//		int pqty = productDAO.getProduct(c.getPname()).getQuantity();
//		if (qty > pqty) {
//			m.addAttribute("cartpage", true);
//			m.addAttribute("title", "FlowerParadise-MyCart");
//			m.addAttribute("cartlist", cartDAO.listCart(c.getCartid()));
//			m.addAttribute("error1", true);
//			m.addAttribute("error", false);
//			m.addAttribute("stock", pqty);
//			m.addAttribute("pid", c.getPid());
//			return "index";
//		} else {
//			if (qty > 3) {
//				m.addAttribute("cartpage", true);
//				m.addAttribute("title", "FlowerParadise-MyCart");
//				m.addAttribute("cartlist", cartDAO.listCart(c.getCartid()));
//				m.addAttribute("error", true);
//				m.addAttribute("error1", false);
//				m.addAttribute("pid", c.getPid());
//				return "index";
//			} else {
//				c.setQuantity(qty);
//				c.setSubTot(c.getPrice() * qty);
//				cartDAO.update(c);
//				return "redirect:/user/viewCart";
//			}
//		}
//	}
//
//	@RequestMapping("/user/decqty")
//	public String decqty(@RequestParam("itemid") int id, Model m) {
//		Cart c = cartDAO.getCart(id);
//		int qty = c.getQuantity() - 1;
//		if (qty == 0) {
//			m.addAttribute("cartpage", true);
//			m.addAttribute("title", "GiftGalore-MyCart");
//			m.addAttribute("cartlist", cartDAO.listCart(c.getCartid()));
//			m.addAttribute("error", true);
//			m.addAttribute("pid", c.getPid());
//			m.addAttribute("error1", false);
//			return "index";
//		} else {
//			c.setQuantity(qty);
//			c.setSubTot(c.getPrice() * qty);
//			cartDAO.update(c);
//			return "redirect:/user/viewCart";
//		}
//	}
//
//}
