package com.example.bookmanager.Repository;

import com.example.bookmanager.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewInfoRepository extends JpaRepository<BookReviewInfo, Long> {
}
