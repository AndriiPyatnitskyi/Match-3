package com.example.demo.repository;

import com.example.demo.model.Player;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {
//    @Query(value = "SELECT p.player_id, MAX(s.value) " +
//            "FROM scores s " +
//            "LEFT JOIN players p " +
//            "ON p.player_id = s.player_id " +
//            "GROUP BY p.player_id "
//            , nativeQuery = true)
//    Page<Player> find(Pageable page);

    @Query("SELECT p, s FROM Player p LEFT JOIN p.scores s ORDER BY s.value DESC")
    List<Player> getTop10Player();

    Player getPlayerByName(String name);
}


