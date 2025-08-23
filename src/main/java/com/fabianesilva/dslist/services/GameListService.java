package com.fabianesilva.dslist.services;

import com.fabianesilva.dslist.dto.GameDTO;
import com.fabianesilva.dslist.dto.GameListDTO;
import com.fabianesilva.dslist.dto.GameMinDTO;
import com.fabianesilva.dslist.entities.Game;
import com.fabianesilva.dslist.entities.GameList;
import com.fabianesilva.dslist.repositories.GameListRepository;
import com.fabianesilva.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    //Esse @Transactional é para seguir as boas práticas, para colocar nos métodos do Service para que ele
    //fique transacional, para que ele garanta que a operaçao vai acontecer, obedecendo aos principios das
    //transações ASID, atomica, consistente, isolada e duravel
    //é utilizado o argumento readOnly=true porque nesse caso estamos assegurando que não faremos nenhuma
    //operação de escrita, então não vamos bloquear o banco de dados para escrita, então vai ficar mais rapido
    //dessa forma

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }
}
