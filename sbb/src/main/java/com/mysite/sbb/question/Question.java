package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter // 일반적으로 entity에는 setter 구현X 권장, 데이터베이스와 바로 연결되기에 자유롭게 변경하도록 하지 않는 것이 좋다.
@Entity // JPA가 엔티티로 인식하는 annotation
public class Question {

    @Id // id 속성을 기본키(primary key)로 지정, 동일한 값을 저장 불가
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    // 데이터 저장시 해당 속성에 따로 값 설정하지 않아도 1씩 자동 증가
    // strategy는 고유번호 생성 옵션
    // GenerationType.IDENTITY는 해당 컬럼만의 독립적 시퀀스 생성, 번호 증가시 사용
    // strategy 옵션을 생략하면 @GeneratedValue가 지정된 컬럼들이 
    // 모두 동일한 시퀀스로 번호를 생성하여 일정한 순서의 고유번호를 가질 수 없음
    private Integer id;

    @Column(length = 200)  // 컬럼의 세부 설정을 위해 지정한 annotation
    private String subject;

    @Column(columnDefinition = "TEXT") 
    // columnDefinition = "TEXT" 는 내용처럼 글자 수 제한을 할 수 없을 때 사용
    private String content;

    private LocalDateTime createDate;

    // 엔티티 속성은 @Column 을 사용하지 않더라도 테이블 컬럼으로 인식
    // @Transient : 테이블 컬럼으로 인식하고 싶이 않은 경우 사용하는 annotation

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author; //여러개의 지룸ㄴ이 한명의 사용자에게 작성될 수 있음!

    private LocalDateTime modifyDate; // 수정일시

    @ManyToMany
    Set<SiteUser> voter; // 추천인은 하나의 질문에 여러사람이, 한사람이 여러개 질문 추천 가능하므로!
    // Set은 voter가 중복되면 안되기 때문에!

}
