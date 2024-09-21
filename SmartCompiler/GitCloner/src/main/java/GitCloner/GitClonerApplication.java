package GitCloner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GitClonerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GitClonerApplication.class, args);
		System.out.println("Good to Go");
	}

}

