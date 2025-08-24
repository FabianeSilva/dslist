package com.fabianesilva.dslist.repositories;

import com.fabianesilva.dslist.entities.Game;
import com.fabianesilva.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {

    //Quando é uma função que não seja o SELECT, seja UPDATA, DELETE ou INSERT, temos que colocar o @Modifying
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
    void uptadeBelongingPosition(Long listId, Long gameId, Integer newPosition);
}
