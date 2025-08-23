package com.fabianesilva.dslist.services;

import com.fabianesilva.dslist.dto.GameDTO;
import com.fabianesilva.dslist.dto.GameMinDTO;
import com.fabianesilva.dslist.entities.Game;
import com.fabianesilva.dslist.projections.GameMinProjection;
import com.fabianesilva.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    //Esse @Transactional é para seguir as boas práticas, para colocar nos métodos do Service para que ele
    //fique transacional, para que ele garanta que a operaçao vai acontecer, obedecendo aos principios das
    //transações ASID, atomica, consistente, isolada e duravel
    //é utilizado o argumento readOnly=true porque nesse caso estamos assegurando que não faremos nenhuma
    //operação de escrita, então não vamos bloquear o banco de dados para escrita, então vai ficar mais rapido
    //dessa forma

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
