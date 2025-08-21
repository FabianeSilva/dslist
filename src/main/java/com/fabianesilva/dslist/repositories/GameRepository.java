package com.fabianesilva.dslist.repositories;

import com.fabianesilva.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
