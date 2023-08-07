package www.dream.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/hello2") //http://localhost:8080/test/hello2?trt=안녕하세요?
	@ResponseBody
	public String hello2(@RequestParam(value="trt", required = false) String msg) {
		return msg; //value="trt" 주소부분에 표시하는 값
	}
	
	// {} path variable   <위의 value와 같은 의미
	@GetMapping("/hello3/{msg}") //부르는 주소
	public String hello3(@PathVariable String msg, Model objToJsp) { //jsp로 넘길정보
		objToJsp.addAttribute("msgname", msg + " aaa뒤에 붙임글"); //앞에껀 호출네임
		return "umdl"; //파일명
	}
}
