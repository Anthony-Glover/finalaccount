import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountSpringDBRepository;

@SpringBootApplication
public class App
{

	public static void main(String[] args) 
	{
		SpringApplication.run(App.class);
	}

	@Bean
	public CommandLineRunner demo(AccountSpringDBRepository repository) 
	{
		return (args) -> 
		{
			// save a couple of Account
			repository.save(new Account("Jack", "Bauer", "AB101"));
			repository.save(new Account("Chloe", "O'Brian", "AB102"));
			repository.save(new Account("Kim", "Bauer", "AB103"));
			repository.save(new Account("David", "Palmer", "AB104"));
			repository.save(new Account("Michelle", "Dessler", "AB105"));
		};
	}
}
