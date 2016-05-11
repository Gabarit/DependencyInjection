package edu.university.domain;


import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Created by gleb on 15.04.16.
 */


@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @PersistenceContext
    private EntityManager em;


    public Product getProduct(long id) {
        return em.find(Product.class, id);
    }

    public void updateProduct(Product updatedEntity) {
        em.persist(updatedEntity);
    }

    public void removeProduct(Product updatedEntity) {
        em.remove(updatedEntity);
    }

    public List<Product> getProducts() {
        return (List<Product>) em.createQuery("SELECT p FROM Product p").getResultList();
    }
}
