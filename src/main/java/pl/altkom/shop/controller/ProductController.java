package pl.altkom.shop.controller;

import java.io.Writer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {

	@RequestMapping("/list")
	public void list(Writer writer, @RequestParam(required = false, value = "page") Integer page,
			@RequestParam(required = false, value = "orderBy") String orderBy,
			@RequestParam(required = false, value = "size") String size) throws Exception {
		writer.write("page - " + page);
		writer.write("\nsize - " + size);
		writer.write("\norderBy - " + orderBy);
	}

	@RequestMapping("/product/{id}")
	public void product(Writer writer, @PathVariable("id") Long id) throws Exception {
		writer.write("id - " + id);
	}

}