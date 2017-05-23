package pl.altkom.shop.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;
import pl.altkom.shop.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Inject
	ProductRepo repo;
	@Inject
	ProductService service;

	@RequestMapping("/list")
	public String list(Model model, @RequestParam(required = false, value = "page") Integer page,
			@RequestParam(required = false, value = "orderBy") String orderBy) throws Exception {

		List<Product> products = repo.getAll();

		model.addAttribute("products", products);
		model.addAttribute("page", page);
		model.addAttribute("orderBy ", orderBy);

		return "product/product-list";
	}

	@RequestMapping("/{id}/delete")
	public String delete(@PathVariable Long id) throws Exception {

		repo.delete(id);
		return "redirect:product/product-list";
		// return "redirect:product/list";
	}

}
