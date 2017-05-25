package pl.altkom.shop.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.altkom.shop.model.Product;

@Repository
@Transactional
public class HibernateProductRepo implements ProductRepo {
	@PersistenceContext
	EntityManager em;

	@Override
	public Long insert(Product product) {
		em.persist(product);
		return product.getId();
	}

	@Override
	public Long count() {
		return (Long) em.createQuery("SELECT count(*) FROM Product p").getSingleResult();
	}

	@Override
	public void delete(Long id) {
		Product product = em.find(Product.class, id);
		em.remove(product);
	}

	@Override
	public Product find(Long id) {
		Product product = em.find(Product.class, id);
		return product;
	}

	@Override
	public List<Product> search(String query) {
		return em.createQuery("FROM Product p WHERE p.name = :query").setParameter("query", query).getResultList();
	}

	@Override
	public void update(Product product) {
		em.merge(product);
	}

	@Override
	public List<Product> getAll() {
		return em.createQuery("FROM Product p").getResultList();
	}
}
