package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne // N:1 관계 답변은 하나의 질문에 여러개 가능
    // Answer 엔티티의 question 속성과 Question 엔티티가 서로 연결가능
    // 데이터베이스에서는 Foreign Key 관계 생성
    // 부모, 자식관계 형성 : 부모가 Question, 자식이 Answer
    private Question question;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private SiteUser author; //여러개의 댓글이 사용자1명에게서 작성될 수 있음!

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;
}
