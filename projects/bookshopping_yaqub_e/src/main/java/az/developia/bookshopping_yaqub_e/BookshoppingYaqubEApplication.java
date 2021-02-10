package az.developia.bookshopping_yaqub_e;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import az.developia.bookshopping_yaqub_e.file.StorageProperties;
import az.developia.bookshopping_yaqub_e.file.StorageService;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class BookshoppingYaqubEApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookshoppingYaqubEApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			// storageService.deleteAll();
			storageService.init();
		};
	}

}
