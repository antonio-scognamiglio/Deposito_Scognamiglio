package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UtenteDto;
import com.example.demo.model.Utente;
import com.example.demo.service.UtenteService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private final UtenteService utenteService;

    UtenteController(UtenteService utentetService) {
        this.utenteService = utentetService;
    }

    @GetMapping("/by-nome/{nome}")
    public String getUtenteByNome(@PathVariable String nome) {
        return "Utente trovato: " + utenteService.getUtenteByNome(nome);
    }

    @PostMapping("/new")
    public Utente postMethodName(@RequestBody UtenteDto utenteDto) {

        return utenteService.creaNuovoUtente(utenteDto);
    }

    @GetMapping("/mario")
    public List<Utente> getUtenteByName() {
        return utenteService.getUtenteMario("mario");
    }
}
