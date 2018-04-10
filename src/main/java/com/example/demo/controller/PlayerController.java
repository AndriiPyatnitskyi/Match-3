package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.model.Score;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/players")
public class PlayerController {
    //TODO replace me with service
    @Autowired
    PlayerRepository repository;

    @GetMapping("/find-all")
    public List<Player> showPlayers() {
        Player player = new Player();
        player.setName("test1");

        Score score = new Score();
        score.setValue(400);
        score.setPlayer(player);



        player.setScores(new HashSet<>(Arrays.asList(score)));

//        Player player1 = new Player();
//        player1.setName("test");
//        player1.setScores(new HashSet<>(Arrays.asList(score1, score1)));
//
//        Player player2 = new Player();
//        player2.setName("test");
//        player2.setScores(new HashSet<>(Arrays.asList(score1, score1)));

//        Player save = repository.save(player);


//        repository.save(player1);
//        repository.save(player2);


        return (List<Player>) repository.findAll();
    }

//    @GetMapping("/show-top-10-players/")
//    public List<Player> showTop10Players() {
//        Page<Player> page = repository.findAll(PageRequest.of(0, 10, new Sort(Sort.Direction.DESC, "scores")));
//        return page.getContent();
//    }







    @GetMapping("/{id}")
    public Optional<Player> showPlayerById(@PathVariable int id) {
        return repository.findById((long) id);
    }


    @CrossOrigin(allowedHeaders="*",allowCredentials="true")
    @PostMapping(value = "/save")
    public Player savePlayer(@RequestBody Player player) {
        return repository.save(player);
    }

    @PutMapping(value = "/edit")
    public Player editPlayer(Player player) {
        return repository.save(player);
    }
}
