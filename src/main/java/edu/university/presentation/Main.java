package edu.university.presentation;

import edu.university.application.ApplicationService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import java.io.Console;

/**
 * Created by gleb on 15.04.16.
 */
public class Main {

    public static void main(String args[]){
        ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationService service = (ApplicationService) appCtx.getBean(ApplicationService.class);

        String input;
        System.out.println("This is simple App, which is using Spring Framework, EclipseLink and MSSQL Server");
        //Console cons;

        //while (input!="-1") {

            System.out.println("The following services are available:");
            System.out.println("1 - Join entities from DB with even ID;");
            System.out.println("2 - Add string \"_3\" to the entity, which begin from the \"E\" letter;");
            System.out.println("-1 - If you want to finish work with this app;");

            //System.in.read();
            input = System.in.toString();

            if (input == "1"){ service.getEntitiesWithEvenID(); }
            if (input == "2"){ service.addWordToNameOfEntityWithE(); }
        //}

    }
}
