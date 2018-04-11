package com.example.demo.service;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository repository;

    public List<Player> getTop10Player() {
        return repository.getTop10Player();
    }

    public Player getPlayerByName(String name) {
        return repository.getPlayerByName(name);
    }

    public Player save(Player player) {
        return repository.save(player);
    }
}
