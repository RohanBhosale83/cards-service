package com.eazybytes.cards.controller.interfaces;

import com.eazybytes.cards.models.Cards;
import com.eazybytes.cards.models.Response;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/cards", produces = "application/json")
@Validated
public interface ICardsController
{
    @PostMapping("/create")
    public ResponseEntity<Response> createCard(@RequestBody @Valid Cards cards);

    @GetMapping("/get")
    public ResponseEntity<Cards> getCard(@RequestParam String mobileNumber);

    @PutMapping("/update")
    public ResponseEntity<Response> updateCard(@RequestBody @Valid Cards cards);

    @DeleteMapping("/delete")
    public ResponseEntity<Response> deleteCard(@RequestParam String mobileNumber);
}
