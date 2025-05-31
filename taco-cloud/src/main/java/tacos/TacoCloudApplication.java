package tacos;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.support.converter.MessageConverter;


@SpringBootApplication
public class TacoCloudApplication {

	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}
}
