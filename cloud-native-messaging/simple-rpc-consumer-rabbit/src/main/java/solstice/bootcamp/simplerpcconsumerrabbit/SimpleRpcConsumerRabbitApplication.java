package solstice.bootcamp.simplerpcconsumerrabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleRpcConsumerRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRpcConsumerRabbitApplication.class, args);
	}

	@RabbitListener(queues = "spring-boot")
    public void process(String message) {
        System.out.println(">>>> " + message);
    }

    @Bean
    public Queue queue() {
	    return new Queue("spring-boot", false);
    }
}
