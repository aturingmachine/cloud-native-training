package solstice.bootcamp;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
