package edu.university.application;

import edu.university.domain.Product;

import java.util.List;

/**
 * Created by gleb on 15.04.16.
 */
public interface ApplicationService {
    List<Product> getEntitiesWithEvenID();
    void addWordToNameOfEntityWithE();
}
