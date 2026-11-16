package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.UtenteDto;
import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

@Service
public class UtenteService {
    private final UtenteRepository utenteRepository;

    UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public String getUtenteByNome(String nome) {
        return utenteRepository.findByNome(nome)
                .map(u -> u.getNome() + " " + u.getCognome())
                .orElse("non trovato");
    }

    public Utente creaNuovoUtente(UtenteDto utenteDto) {
        Utente newUtente = new Utente();
        newUtente.setEta(utenteDto.eta());
        newUtente.setCognome(utenteDto.cognome());
        newUtente.setNome(utenteDto.nome());
        return utenteRepository.save(newUtente);
    }

    public List<Utente> getUtenteMario(String string) {
        List<Utente> utenti = utenteRepository.findAll();
        return utenti.stream()
                .filter(utente -> utente.getNome().equals(string))
                .collect(Collectors.toList());
    }
}
