package com.mika.demo.HelloWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @RequestMapping("/say-hello")
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("/say-hello-html")
    public StringBuffer sayHelloHTML() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html lang=\"en\">");
        sb.append("<head>");
        sb.append("<title>My Fancy Titile</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("<h1>Hello World-We rock</h1>");
        sb.append("</body>");
        sb.append("</html>");
        return sb;
    }

    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp() {
        return "helloWorld";
    }
}
