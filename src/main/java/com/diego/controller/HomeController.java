package com.diego.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.diego.dao.ProductosDAO;
import com.diego.modelo.Producto;

@Controller
public class HomeController {

	@Autowired
	private ProductosDAO productosDao;
	
	@RequestMapping("/")
	public ModelAndView handleRequest() throws Exception {
		String mensaje_enviado="bienvenido a la aplicación de Spring";
		ModelAndView model = new ModelAndView("bienvenida");
		model.addObject("mensaje", mensaje_enviado);
		return model;
	}
	

	@RequestMapping("/listado")
	public ModelAndView verListado() throws Exception {
		List<Producto> listProductos = productosDao.list();
		ModelAndView model = new ModelAndView("productosList");
		model.addObject("productosList", listProductos);
		return model;
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newProducto() {
		ModelAndView model = new ModelAndView("productosForm");
		model.addObject("producto", new Producto());
		return model;		
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editProducto(HttpServletRequest request) {
		int productoId = Integer.parseInt(request.getParameter("id"));
		Producto producto= productosDao.get(productoId);
		ModelAndView model = new ModelAndView("productosForm");
		model.addObject("producto", producto);
		return model;		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteProducto(HttpServletRequest request) {
		int productoId = Integer.parseInt(request.getParameter("id"));
		productosDao.delete(productoId);
		return new ModelAndView("redirect:/listado");		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveProducto(@ModelAttribute Producto producto) {
		productosDao.saveOrUpdate(producto);
		return new ModelAndView("redirect:/listado");
	}
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }
	 private String getPrincipal(){
	        String userName = null;
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	 
	        if (principal instanceof UserDetails) {
	            userName = ((UserDetails)principal).getUsername();
	        } else {
	            userName = principal.toString();
	        }
	        return userName;
	
}
}
