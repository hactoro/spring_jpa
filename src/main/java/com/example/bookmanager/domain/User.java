package com.example.bookmanager.domain;

import com.example.bookmanager.domain.listener.MyEntityListener;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor // Jpa 에서는 필수 lambok annotation!
@AllArgsConstructor
//@RequiredArgsConstructor
//@EqualsAndHashCode // 나중에 공부해라!
//@Data // 위에 선언한 여러 annotation 을 모두 포함하는 annotation 이다.
//@Builder // ??
@Entity
@Data
@Slf4j
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(MyEntityListener.class)
public class User extends BaseEntity {
    @Id //@RequiredArgsConstructor 는 @NonNull 이 없으면, @NoArgsConstructor 와 동일하게 작동!
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Review> review = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<UserHistory> userHistories = new ArrayList<>();

//    @Column(updatable = false) //처음 생성될 때만
//    private LocalDateTime createdAt;
//
//    private LocalDateTime updatedAt;
//
//    @PrePersist
//    public void prePersist(){
//        System.out.println("------prePersist-------");
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//        this.updatedAt = LocalDateTime.now();
//    }


}
