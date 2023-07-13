package com.lucaslucenak.gameslist.services;

import com.lucaslucenak.gameslist.dtos.GameListDTO;
import com.lucaslucenak.gameslist.models.GameListModel;
import com.lucaslucenak.gameslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameListService {

    @Autowired
    GameListRepository gameListRepository;

    public GameListService() {
    }

    public List<GameListDTO> findAllGameLists() {
        List<GameListDTO> gameListDTOS = new ArrayList<>();
        for (GameListModel i : gameListRepository.findAll()) {
            gameListDTOS.add(new GameListDTO(i));
        }
        return  gameListDTOS;
    }

    public GameListDTO findGameListById(Long id) {
        return new GameListDTO(gameListRepository.findById(id).get());
    }
}
