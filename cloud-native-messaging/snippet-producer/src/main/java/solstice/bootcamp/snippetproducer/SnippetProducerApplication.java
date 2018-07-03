package solstice.bootcamp.snippetproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import solstice.bootcamp.snippetproducer.domain.Snippet;

@SpringBootApplication
@EnableScheduling
public class SnippetProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnippetProducerApplication.class, args);
	}

	private final RabbitTemplate template;

	@Autowired
	public SnippetProducerApplication(RabbitTemplate template){
		this.template = template;
	}

	@Scheduled(fixedDelay = 1000)
	public void sender() {
		Snippet snippet = new Snippet("JavaScript: Alert","alert('Hi there!');");
		template.convertAndSend(snippet);
	}
}
