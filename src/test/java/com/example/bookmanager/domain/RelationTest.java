package com.example.bookmanager.domain;

import com.example.bookmanager.Repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class RelationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void reviewTest(){
            User user = new User();
            user.setName("hsd");
            user.setEmail("hsd@gmail.com");
            userRepository.save(user);

            Review review1 = new Review();
            Review review2 = new Review();

            review1.setTitle("치킨은 왜 맛있는가?");
            review1.setContent("이 책을 보고 치킨 두 마리 시켰어요.");
            review1.setScore(4.3f);
            review1.setUser(user);
            reviewRepository.save(review1);

            List<Review> reviewList = new ArrayList<>();
            reviewList.add(review1);

            user.setReview(reviewList);
            userRepository.save(user);

            System.out.println(review1.getUser().getName());

            System.out.println(user.getReview().get(0).getContent());

            System.out.println("-----user history logging-----");
            System.out.println(userHistoryRepository.findAll());

            System.out.println("-----find history from user entity------");
//            System.out.println(userRepository.getById(1L).getUserHistories());
            userRepository.findAll().forEach(
                    u -> u.getUserHistories().forEach(System.out::println)
            );

    }

    @Test
    public void relationTest2(){
        Publisher publisher = new Publisher();
        publisher.setName("하성대");

        Book book = new Book();
        book.setName("인생 ㅅㅂ꺼");
        book.setPublisher(publisher);

        List<Book> books = new ArrayList<>();
        books.add(book);

        publisher.setName("책가게");
//        publisher.setBooks(books);

        bookRepository.save(book);
        publisherRepository.save(publisher);


        bookRepository.findAll().forEach(
                b -> System.out.println(b.getName())
        );

        System.out.println("---출판사 : " );
        publisherRepository.findByName("책가게").getBooks().forEach(
                b -> System.out.println(b.getName())
        );
    }

}
