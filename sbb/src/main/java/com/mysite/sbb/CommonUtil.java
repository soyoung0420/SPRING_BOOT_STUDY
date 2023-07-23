package com.mysite.sbb;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

@Component // 해당 어노테이션 사용시 스프링부트에 의해 관리되는 빈(자바객체)로 등록됨
public class CommonUtil {

    public String markdown(String markdown){

        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document); 
        // 마크다운 텍스트를 html로 변환하여 리턴함

    }

}
