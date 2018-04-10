package com.example.demo.repository;

import com.example.demo.model.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ScoreRepository extends PagingAndSortingRepository<Score, Long> {
    Page<Score> findByPlayerName(String playerName, Pageable pageable);

}
