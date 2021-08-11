package dio.experts.dioproductcatalog.repository;

import dio.experts.dioproductcatalog.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
