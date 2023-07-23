package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 스프링부트의 컨트롤러 지정 annotation
public class MainController {

    @GetMapping("/sbb") // 요청된 url과의 매핑을 담당
    @ResponseBody // url 요청에 대한 응답을 리턴
    // 생략시 index라는 이름의 템플릿 파일을 찾음
    public String index(){

        return "안녕하세요 sbb에 오신것을 환영합니다.";

    }
    @GetMapping("/")
    public String root(){
        return "redirect:/question/list";
    }

}
