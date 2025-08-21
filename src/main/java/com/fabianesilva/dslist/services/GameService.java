package com.fabianesilva.dslist.services;

import com.fabianesilva.dslist.dto.GameMinDTO;
import com.fabianesilva.dslist.entities.Game;
import com.fabianesilva.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
