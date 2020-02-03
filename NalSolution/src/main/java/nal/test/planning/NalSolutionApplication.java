package nal.test.planning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class NalSolutionApplication {

    public static void main(String[] args) {
        SpringApplication.run(NalSolutionApplication.class, args);
    }

}
