package com.example.bookmanager.domain;

import com.example.bookmanager.domain.listener.Auditable;
import com.example.bookmanager.domain.listener.MyEntityListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//@EntityListeners(MyEntityListener.class)
//public class Book implements Auditable { //Auditable 이라는 Interface 를 사용한 이유는 공통적으로 사용될 method를 강제하기 위함!
                                         //@Data 는 createdAt, updatedAt의 getter/setter를 생성하는데
                                         // 이는 Interface 에서 정의한 method 이다.
public class Book extends BaseEntity{

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String author;

    @ManyToOne
    private Publisher publisher;



//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
//
//    @PrePersist
//    public void prePersist(){
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
}
