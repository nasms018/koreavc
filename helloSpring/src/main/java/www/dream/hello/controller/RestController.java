package www.dream.hello.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.dream.hello.model.MemberVO;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rapi")
public class RestController {

	@GetMapping("/hi") 
	public List<String> Hello4(@RequestParam(value="trt", required = false) String vvv) {
		List<String> ret = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->ret.add(val+vvv));
		return ret;
	}//http://localhost:8080/rapi/hi?trt=안녕하세요
	
	@GetMapping("/members/all") 
	public List<MemberVO> listAllMember(@RequestParam(value="trt") String msg){
		List<MemberVO> ret = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->ret.add(new MemberVO(msg + val, val, "mjadsf")));
		return ret;
	}//http://localhost:8080/rapi/members/all?trt=홍길동
	
	@GetMapping(value = "/members/allxml", produces = MediaType.APPLICATION_JSON_UTF8_VALUE) //부르는 주소
	public List<MemberVO> listAllMemberXML(@RequestParam(value="trt") String msg){
		List<MemberVO> ret = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->ret.add(new MemberVO(msg + val, val, "mjadsf;")));
		return ret;
	} //http://localhost:8080/rapi/members/allxml?trt=홍길동
	
	
	@Value("${news.imgdir}")
	private String myConfig;
	
	@GetMapping("/hello6")
	public List<String> Hello6(@RequestParam(value="trt", required = false) String vvv) {
		List<String> ret = new ArrayList<>();
		IntStream.range(0, 10).forEach(val->ret.add(myConfig+val+vvv));
		return ret;
	} // http://localhost:8080/rapi/hello6?trt=안녕
	
	
}
