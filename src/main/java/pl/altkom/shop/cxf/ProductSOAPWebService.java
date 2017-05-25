package pl.altkom.shop.cxf;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@Component
@WebService
@Path("/soap")
public class ProductSOAPWebService {

	@Inject
	ProductRepo repo;

	@WebMethod
	public Product findById(@WebParam(name = "id") Long id) {
		return repo.find(id);
	}
}
