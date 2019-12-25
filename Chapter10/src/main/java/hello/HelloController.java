package hello;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;

@Controller
@EnableAutoConfiguration
//@RestController
public class HelloController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }
    public static void main(String[] args) throws Exception{
         SpringApplication.run(HelloController.class,args);
    }
}
