package com.fabianesilva.dslist.services;

import com.fabianesilva.dslist.dto.GameDTO;
import com.fabianesilva.dslist.dto.GameListDTO;
import com.fabianesilva.dslist.dto.GameMinDTO;
import com.fabianesilva.dslist.entities.Game;
import com.fabianesilva.dslist.entities.GameList;
import com.fabianesilva.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

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

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        //a linha de comando abaixo é um ternário, onde ? significa que se o source for menor que o destination então
        //e o : é o else, senão, caso contrário o menor será o destination
        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.uptadeBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
