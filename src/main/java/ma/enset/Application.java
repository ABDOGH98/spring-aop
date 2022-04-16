package ma.enset ;

import ma.enset.service.IMetier;
import ma.enset.service.SecurityContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"ma.enset"})
public class Application {

    public static void main(String[] args) {
        try{
            SecurityContext.authentication("root","root",new String[]{"ADMIN"});

            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
            IMetier metier = applicationContext.getBean(IMetier.class);

            System.out.println(metier.getClass().getName());
            metier.process();
            System.out.println(metier.compute());
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
}
