package edu.university.application;

import edu.university.domain.Product;
import edu.university.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleb on 15.04.16.
 */
@Service
@Scope("singleton")
public class ApplicationServiceImpl implements ApplicationService {

    @Autowired
    private ProductRepository repository;


    @Transactional(readOnly = true)
    public List<Product> getEntitiesWithEvenID() {

        List<Product> products = repository.getProducts();
        List<Product> newProd = new ArrayList<Product>();

        for (Product product: products) {
            if((product.getId()%2)==0)
                newProd.add(product);
        }

        return newProd;
    }

    @Transactional
    public void addWordToNameOfEntityWithE() {

        List<Product> products = repository.getProducts();

        for (Product product: products) {
            if(product.getName().startsWith("E")) {
                System.out.println("Name: " + product.getName());
                product.setName(product.getName() + "_3");
                System.out.println("New name:" + product.getName());
                repository.updateProduct(product);
            }
        }
    }
}
