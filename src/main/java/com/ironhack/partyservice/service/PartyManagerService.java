package com.ironhack.partyservice.service;

import com.ironhack.partyservice.dto.CharacterDTO;
import com.ironhack.partyservice.dto.LevelUpDTO;

import java.util.List;

public interface PartyManagerService {

    List<CharacterDTO> getParty(String username);

    List<CharacterDTO> getGraveYard(String username);

    CharacterDTO getCharacterById(String username, Long id);

    CharacterDTO levelUpCharacter(String username, LevelUpDTO levelUpDTO);

    CharacterDTO healCharacter(String username, Long id, Integer healAmount);

    CharacterDTO reviveCharacter(String username, Long id, Integer healAmount);

    void removeCharacter(String username, Long id);

    void updatePartyLevel(String username);

}
