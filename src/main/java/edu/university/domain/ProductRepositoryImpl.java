package edu.university.domain;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.university.domain.Product;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gleb on 15.04.16.
 */

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Product getProduct(long id) {
        return em.find(Product.class, id);
    }

    @Transactional
    public void updateProduct(Product updatedEntity) {
        em.refresh(updatedEntity);
    }

    @Transactional
    public void removeProduct(Product updatedEntity) {
        em.remove(updatedEntity);
    }

    @Transactional
    public List<Product> getProducts() {
        return (List<Product>) em.createQuery("SELECT p FROM Product p").getResultList();
    }
}
