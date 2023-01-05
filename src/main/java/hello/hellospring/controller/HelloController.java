package hello.hellospring.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","hello!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name); // 키, 밸류
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http에서 body부에 데이터를 직접 넣어주겠다라는 의미
    public String helloString(@RequestParam("name") String name) { // spring 이라는 데이터를 넣으면
        return "hello" + name; // " hello spring " 를 그냥 직접 반환
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();

        hello.setName(name);

        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
