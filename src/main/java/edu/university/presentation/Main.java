package edu.university.presentation;

import edu.university.application.ApplicationService;
import edu.university.domain.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created by gleb on 15.04.16.
 */
public class Main {

    public static void main(String args[]){
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationService service = (ApplicationService) appCtx.getBean(ApplicationService.class);

        Scanner input = new Scanner(System.in);
        int option;
        System.out.println("This is simple App, which is using Spring Framework, EclipseLink and MSSQL Server");

        do {

            System.out.println("The following services are available:");
            System.out.println("1 - Join entities from DB with even ID;");
            System.out.println("2 - Add string \"_3\" to the entity, which begin from the \"E\" letter;");
            System.out.println("-1 - If you want to finish work with this app;");

            option = input.nextInt();

            if (option == 1){
                List<Product> products;
                products = service.getEntitiesWithEvenID();
                for (Product product : products) {
                    System.out.println("ID:    "+product.getId());
                    System.out.println("Name:  "+product.getName());
                    System.out.println("Price: "+product.getPrice());
                }
            }
            if (option == 2){ service.addWordToNameOfEntityWithE(); }
        }while (option!=-1);

    }
}
