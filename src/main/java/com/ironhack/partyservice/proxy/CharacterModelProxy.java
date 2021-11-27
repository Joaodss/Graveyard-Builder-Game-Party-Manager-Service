package com.ironhack.partyservice.proxy;

import com.ironhack.partyservice.dto.CharacterDTO;
import com.ironhack.partyservice.dto.LevelUpDTO;
import com.ironhack.partyservice.dto.NewCharacterDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@FeignClient(value = "character-model-service", path = "/api/v1/characters")
public interface CharacterModelProxy {

    // -------------------- GET --------------------

    @GetMapping("/id/{id}")
    @ResponseStatus(OK)
    CharacterDTO getCharacterById(@PathVariable Long id);

    @GetMapping("/party/{username}")
    @ResponseStatus(OK)
    List<CharacterDTO> getCharactersByUserUsernameActive(@PathVariable String username);

    @GetMapping("/graveyard/{username}")
    @ResponseStatus(OK)
    List<CharacterDTO> getCharactersByUserUsernameGraveyard(@PathVariable String username);


    // -------------------- POST --------------------
    @PostMapping("/create")
    @ResponseStatus(CREATED)
    CharacterDTO createCharacter(@RequestBody @Valid NewCharacterDTO newCharacterDTO);


    // -------------------- PUT --------------------
    @PutMapping("/update")
    @ResponseStatus(OK)
    CharacterDTO updateCharacter(@RequestBody CharacterDTO updateCharacterDTO);

    @PutMapping("/update/levelUp")
    @ResponseStatus(OK)
    CharacterDTO levelUpCharacter(@RequestBody LevelUpDTO levelUpDTO);


    // -------------------- DELETE --------------------
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(OK)
    void deleteCharacterById(@PathVariable Long id);

}
