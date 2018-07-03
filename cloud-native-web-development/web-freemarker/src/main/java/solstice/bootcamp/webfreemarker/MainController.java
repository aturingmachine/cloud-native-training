package solstice.bootcamp.webfreemarker;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

@Controller
public class MainController {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, YYYY");

    @GetMapping("/")
    public ModelAndView home() {
        List<Marketing> offers = asList(
                new Marketing("Product", "Easy Payments! Only $1/month with 500 code snippets."),
                new Marketing("GitHub Gists", "Easy Integration with GitHub Gists. Share with everybody!"),

                new Marketing("REST API", "Powerful REST API to manage your Code Snippets in your own Programming Language"),
                new Marketing("OAuth Security", "Keep you Code Snippets secured with Authentication and Authorization based on OAuth.")
        );

        Map<String, Object> model = new HashMap<>();
        model.put("today", LocalDate.now().format(formatter));
        model.put("offers", offers);

        return new ModelAndView("home", model);
    }
}
