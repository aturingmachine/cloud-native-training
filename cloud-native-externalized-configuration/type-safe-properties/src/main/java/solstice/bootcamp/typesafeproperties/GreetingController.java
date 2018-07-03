package solstice.bootcamp.typesafeproperties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private final PersonProperties personProperties;

    public GreetingController(PersonProperties personProperties) {
        this.personProperties = personProperties;
    }

    @GetMapping("/")
    public String greeting() {
        return personProperties.getGreeting() + " Spring Boot! " +
                personProperties.getFarewell() + " Spring Boot! ";
    }
}
