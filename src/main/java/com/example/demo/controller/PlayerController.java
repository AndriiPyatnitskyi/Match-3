package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.model.Score;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.ScoreRepository;
import com.example.demo.service.PlayerService;
import com.example.demo.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    PlayerService playerService;

    @PostMapping(value = "/save")
    public Player savePlayer(@RequestBody Player player) {
        return playerService.save(player);
    }

    @PutMapping(value = "/edit")
    public Player editPlayer(@RequestBody Player player) {
        Player playerByName = playerService.getPlayerByName(player.getName());
        for (Score score : player.getScores()) {
            score.setPlayer(playerByName);
            scoreRepository.save(score);
        }

        playerByName.setScores(player.getScores());

        return playerService.save(playerByName);
    }

    @GetMapping("/show-top-10-players/")
    public List<Player> showTop10Players() {
        return playerService.getTop10Player();
    }
}
