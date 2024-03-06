package note.javadev_homework_16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public ModelAndView getHello() {
        return new ModelAndView("test/hello");
    }
}
