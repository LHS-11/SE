package hello.SE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeApplication.class, args);
	}

}
