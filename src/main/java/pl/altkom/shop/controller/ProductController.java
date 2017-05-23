package pl.altkom.shop.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.InMemoryProductRepo;
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
			@RequestParam(required = false, value = "orderBy") String orderBy,
			@RequestParam(required = false, value = "query") String query) throws Exception {

		model.addAttribute("page", page);
		model.addAttribute("orderBy ", orderBy);
		model.addAttribute("query ", query);

		if (query != "") {
			@SuppressWarnings("unchecked")
			InMemoryProductRepo products = new InMemoryProductRepo();
			List<Product> allProducts = repo.getAll();

			for (Product product : allProducts) {
				if (product.getName() == query) {
					products.insert(product);
				}
			}
			model.addAttribute("products", products);
		} else {
			List<Product> products = repo.getAll();
			model.addAttribute("products", products);
		}

		return "product/product-list";
	}

	@RequestMapping("/{id}/delete")
	public String delte(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) throws Exception {
		repo.delete(id);
		return "redirect:/product/list";
	}

	// Add

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String save(@ModelAttribute("product") Product product) throws Exception {

		List<Product> products = repo.getAll();
		Product lastProduct = products.get(products.size() - 1);
		product.setId(lastProduct.getId() + 1);

		repo.insert(product);
		return "redirect:/product/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model) throws Exception {
		Product product = new Product();

		product.setPrice(BigDecimal.TEN);
		product.setQuantity(100);
		product.setName("New product");

		model.addAttribute("product", product);

		return "product/add";
	}

	// Edit

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable("id") Long id) throws Exception {

		Product product = repo.find(id);
		model.addAttribute("product", product);

		return "product/add";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String editSave(@ModelAttribute("product") Product product) throws Exception {

		Long id = product.getId();
		repo.delete(id);
		System.out.println(id);
		repo.insert(product);

		return "redirect:/product/list";
	}

}
