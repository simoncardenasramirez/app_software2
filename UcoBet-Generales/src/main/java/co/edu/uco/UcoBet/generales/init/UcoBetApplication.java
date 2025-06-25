package co.edu.uco.ucobet.generales.init;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"co.edu.uco.UcoBet"})
@EntityScan(basePackages= {"co.edu.uco.UcoBet.generales.application.secondaryports.entity"})
@ComponentScan(basePackages= {"co.edu.uco.UcoBet.generales"})
public class UcoBetApplication  {

	public static void main(String[] args) {
	    SpringApplication.run(UcoBetApplication.class, args);
	}

}
