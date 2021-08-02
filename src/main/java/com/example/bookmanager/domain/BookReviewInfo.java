package com.example.bookmanager.domain;

import javax.persistence.*;

@Entity
public class BookReviewInfo extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float average_review_score;

    private int review_count;

    @OneToOne
    private Book book;
}
