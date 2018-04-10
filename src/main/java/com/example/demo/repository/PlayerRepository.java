package com.example.demo.repository;

import com.example.demo.model.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional

//JpaRepository
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {
//    @Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
//    public List<Person> find(@Param("lastName") String lastName);


//    SELECT p.name, s.value FROM players as p, scores as s
//    WHERE p.player_id = s.player_id
//    ORDER BY s.value DESC

//    SELECT p.name, s.value FROM players as p LEFT JOIN scores as s
//    ON p.player_id = s.player_id
//    ORDER BY s.value DESC

    @Query("SELECT p, s FROM Player p LEFT JOIN p.scores s ORDER BY s.value DESC")
    List<Player> getTop10Player();
}
