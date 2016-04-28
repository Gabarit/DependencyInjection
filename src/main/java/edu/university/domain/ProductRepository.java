package edu.university.domain;
import java.util.List;

/**
 * Created by gleb on 14.04.16.
 */
public interface ProductRepository {

    Product getProduct(long id);

    void updateProduct(Product updatedEntity);

    void removeProduct(Product updatedEntity);

    List<Product> getProducts();
}
