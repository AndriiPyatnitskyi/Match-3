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
@RequestMapping("/")
public class ScoreController {
    //TODO replace me with service
    @Autowired
    ScoreService scoreService;
    @Autowired
    PlayerService playerService;

//    @GetMapping("/find-all")
//    public List<Score> showScores() {
//        return (List<Score>) scoreService.findAll();
//    }


    @GetMapping("/player-statistics/{playerName}")
    public List<Score> showPlayerStatistics(@PathVariable String playerName) {
        Page<Score> page = scoreService.findByPlayerName(playerName, PageRequest.of(0, 10, DESC, "id"));
        return page.getContent();
    }

    @GetMapping("/show-top-10-players/")
    public List<Player> showTop10Players() {
        return playerService.getTop10Player();
    }
}
