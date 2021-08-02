package com.example.bookmanager.domain.listener;

import com.example.bookmanager.Interceptor.AuthHandler;
import com.example.bookmanager.Repository.BookRepository;
import com.example.bookmanager.Repository.UserHistoryRepository;
import com.example.bookmanager.Repository.UserRepository;
import com.example.bookmanager.domain.Book;
import com.example.bookmanager.domain.User;
import com.example.bookmanager.domain.UserHistory;
import com.example.bookmanager.domain.listener.Auditable;
import com.example.bookmanager.support.ListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class MyEntityListener {
//    @Autowired
//    UserRepository userRepository;

//    @PrePersist
//    public void prePersist(Object o){
//        if( o instanceof Auditable){
//            ((Auditable) o).setCreatedAt(LocalDateTime.now());
//            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
//        }
//        userRepository.findAll().forEach(System.out::println);


    @PostPersist
    @PostUpdate
    public void postPersistAndPostUpdate(Object o){
//        if ( o instanceof User){
//            System.out.println("------post listener event----");
//            System.out.println(((User) o).getName());
//        }
//        Book book = new Book();
//        book.setAuthor("hsd");
//        BookRepository bookRepository = ListenerSupport.getBean(BookRepository.class);
//        bookRepository.save(book);
//
//        System.out.println("----------Get Bean---------");
//        bookRepository.findAll().forEach(System.out::println);

        User user = (User)o;
        UserHistory userHistory = new UserHistory();
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setId(user.getId());

        UserHistoryRepository userHistoryRepository = ListenerSupport.getBean(UserHistoryRepository.class);
        userHistoryRepository.save(userHistory);
    }
}
