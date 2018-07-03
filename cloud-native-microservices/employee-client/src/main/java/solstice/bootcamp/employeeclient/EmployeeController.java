package solstice.bootcamp.employeeclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
public class EmployeeController {

    private RestTemplate restTemplate = new RestTemplate();
    private String url;

    EmployeeController(@Value("${directory.url}") String url) {
        this.url = url;
    }

    @RequestMapping("/employees")
    public List<Employee> getDirectory() {
        ParameterizedTypeReference<Resource<Company>> emp = new ParameterizedTypeReference<Resource<Company>>() {};

        ResponseEntity<Resource<Company>> response = restTemplate.exchange(
                RequestEntity.get(URI.create(this.url))
                        .accept(MediaTypes.HAL_JSON)
                        .build(),
                emp
        );

        assert response != null;
        if(response.getStatusCode() == HttpStatus.OK){
            Company  company = response.getBody().getContent();
            assert company != null;
            return company.getEmployees();
        } else
            return Collections.emptyList();

    }
}


@ControllerAdvice
class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { HttpClientErrorException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "<h1><font face=\"verdana\">No Directory found.</font></h1>";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
