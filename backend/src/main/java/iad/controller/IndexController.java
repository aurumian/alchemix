package iad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/login")
    public String getIndex(){
        return "index.html";
    }

    @GetMapping("/craft")
    public String getIndex2(){
        return "forward:/";
    }

    @GetMapping("/clan")
    public String getIndex3(){
        return "forward:/";
    }

    @GetMapping("/admin/**")
    public String getIndex4(){
        return "forward:/";
    }



}
