package solstice.bootcamp.simplerpcconsumerrabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@SpringBootApplication
public class SimpleRpcProducerRabbitApplication {

    private final RabbitTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(SimpleRpcProducerRabbitApplication.class, args);
    }

    @Autowired
    public SimpleRpcProducerRabbitApplication(RabbitTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 1000)
    public void sendMessage() {
        String timestamp = new SimpleDateFormat("HH:mm:ss").format(new Date());
        String message = "Hello world! " + timestamp;

        this.template.convertAndSend("spring-boot", message);
    }

    @Bean
    public Queue queue() {
        return new Queue("spring-boot", false);
    }
}