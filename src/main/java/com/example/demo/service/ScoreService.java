package com.example.demo.service;

import com.example.demo.model.Score;
import com.example.demo.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    ScoreRepository repository;

    public Page<Score> findByPlayerName(String playerName, Pageable pageable){
        return repository.findByPlayerName(playerName, pageable);
    }
}
