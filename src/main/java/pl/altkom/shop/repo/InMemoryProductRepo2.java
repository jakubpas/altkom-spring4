package pl.altkom.shop.repo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("prod")
@Repository
public class InMemoryProductRepo2 implements ProductRepo {

}
