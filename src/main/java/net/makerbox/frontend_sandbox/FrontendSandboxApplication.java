package net.makerbox.frontend_sandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class FrontendSandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendSandboxApplication.class, args);
	}

	@RequestMapping("/")
	@ResponseBody
	String index() {
		return """
				Hi. You can use return response using string literal when
				<code>@ResponseBody</code> annotation is added to request handler.
				""";
	}


	@RequestMapping("/hello")
	public String hello(@RequestParam(value="name", required=true) String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}
}
