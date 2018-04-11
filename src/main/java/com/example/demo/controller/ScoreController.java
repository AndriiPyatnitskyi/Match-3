package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.model.Score;
import com.example.demo.service.PlayerService;
import com.example.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.DESC;


@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @GetMapping("/player-statistics/{playerName}")
    public List<Score> showPlayerStatistics(@PathVariable String playerName) {
        Page<Score> page = scoreService.findByPlayerName(playerName, PageRequest.of(0, 10, DESC, "id"));
        return page.getContent();
    }
}
