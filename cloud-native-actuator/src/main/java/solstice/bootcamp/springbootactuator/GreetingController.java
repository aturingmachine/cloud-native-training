package solstice.bootcamp.springbootactuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private Counter counter;

    public GreetingController(MeterRegistry meterRegistry) {
        this.counter = meterRegistry.counter("counter.services.greeting.invoked");
    }

    @GetMapping("/")
    public String hello() {
        counter.increment();
        return "Hello World!";
    }
}
