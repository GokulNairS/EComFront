//package com.niit.EComFront.Controller;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Iterator;
//import java.util.UUID;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.niit.EComBack.DAO.cartDAO;
//import com.niit.EComBack.DAO.AddressDAO;
//import com.niit.EComBack.DAO.orderDAO;
//import com.niit.EComBack.DAO.ProductDAO;
//import com.niit.EComBack.Model.Cart;
//import com.niit.EComBack.Model.Orders;
//import com.niit.EComBack.Model.Product;
//
//@Controller
//public class OrderController {
//
//	@Autowired
//	cartDAO cartDAO;
//
//	@Autowired
//	orderDAO orderDAO;
//
//	@Autowired
//	AddressDAO addressDAO;
//
//	@Autowired
//	ProductDAO productDAO;
//
//	@RequestMapping("/user/placeorder")
//	String placeorder(@RequestParam("addid") int id, HttpSession session) {
//		ArrayList<Cart> cartlist = (ArrayList<Cart>) cartDAO
//				.listCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
//		Iterator<Cart> cartiterator = cartlist.listIterator();
//		while (cartiterator.hasNext()) {
//			Cart cart2 = (Cart) cartiterator.next();
//			Long uuid = UUID.randomUUID().getMostSignificantBits();
//			String oid = "OD" + uuid.toString().replace('-', '2');
//			Orders order = new Orders();
//			Product p = productDAO.getProduct(cart2.getPname());
//			int qty = p.getQuantity() - cart2.getQuantity();
//			System.out.println(qty);
//			p.setQuantity(qty);
//			productDAO.update(p);
//			order.setOrderid(oid);
//			order.setCartid(Integer.parseInt(session.getAttribute("usercartid").toString()));
//			order.setAddressid(id);
//			order.setOdate(new Date());
//			order.setPid(cart2.getPid());
//			order.setProduct_Name(cart2.getPname());
//			order.setQuantity(cart2.getQuantity());
//			order.setPrice(cart2.getSubTot());
//			orderDAO.add(order);
//			cartDAO.delete(cart2);
//		}
//		return "redirect:/user/viewOrders";
//	}
//
//	@RequestMapping("/user/viewOrders")
//	String viewOrders(Model m, HttpSession session) {
//		m.addAttribute("orderlist", orderDAO.listOrder(Integer.parseInt(session.getAttribute("usercartid").toString())));
//		m.addAttribute("orderpage", true);
//		return "index";
//	}
//
//	@RequestMapping("/user/viewbill")
//	String viewBills(Model m, HttpSession session, @RequestParam("orderid") String id) {
//		Orders o = orderDAO.getOrder(id);
//		m.addAttribute("order", o);
//		m.addAttribute("address", addressDAO.getAddress(o.getAddressid()));
//		m.addAttribute("billpage", true);
//		return "index";
//	}
//}
