package com.gestioneconcessionari.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestioneconcessionari.dto.request.ConcessionarioRequest;
import com.gestioneconcessionari.dto.response.ConcessionarioResponse;
import com.gestioneconcessionari.entity.Concessionario;
import com.gestioneconcessionari.mapper.EntityMapper;
import com.gestioneconcessionari.repository.CasaMadreRepository;
import com.gestioneconcessionari.repository.ConcessionarioRepository;

@Service
public class ConcessionarioService {

    private final EntityMapper entityMapper;
    private final ConcessionarioRepository concessionarioRepo;
    private final CasaMadreRepository casaMadreRepo;

    public ConcessionarioService(ConcessionarioRepository concessionarioRepo, CasaMadreRepository casaMadreRepo,
            EntityMapper entityMapper) {
        super();
        this.concessionarioRepo = concessionarioRepo;
        this.casaMadreRepo = casaMadreRepo;
        this.entityMapper = entityMapper;
    }

    @Transactional
    public List<ConcessionarioResponse> findAll() {
        List<Concessionario> concessionari = concessionarioRepo.findAll();
        return concessionari.stream().map(entityMapper::toConcessionarioResponse).toList();
    }

    @Transactional
    public ConcessionarioResponse create(ConcessionarioRequest request) {
        if (!casaMadreRepo.existsById(request.casaMadreId())) {
            throw new IllegalArgumentException("Casa Madre con id " + request.casaMadreId() + " non trovata");
        }

        Concessionario concessionario = new Concessionario();
        concessionario.setNome(request.nome());
        concessionario.setCitta(request.citta());
        concessionario.setIndirizzo(request.indirizzo());
        concessionario.setTelefono(request.telefono());
        concessionario.setFatturato(request.fatturato());
        concessionario.setCasaMadre(casaMadreRepo.findById(request.casaMadreId()).orElseThrow());

        Concessionario saved = concessionarioRepo.save(concessionario);
        return entityMapper.toConcessionarioResponse(saved);
    }

    @Transactional
    public ConcessionarioResponse findById(Long id) {
        Concessionario concessionario = concessionarioRepo.findById(id).orElseThrow();
        return entityMapper.toConcessionarioResponse(concessionario);
    }

    @Transactional
    public ConcessionarioResponse update(Long id, ConcessionarioRequest request) {
        Concessionario concessionario = concessionarioRepo.findById(id).orElseThrow();

        if (!casaMadreRepo.existsById(request.casaMadreId())) {
            throw new IllegalArgumentException("Casa Madre con id " + request.casaMadreId() + " non trovata");
        }

        concessionario.setNome(request.nome());
        concessionario.setCitta(request.citta());
        concessionario.setIndirizzo(request.indirizzo());
        concessionario.setTelefono(request.telefono());
        concessionario.setFatturato(request.fatturato());
        concessionario.setCasaMadre(casaMadreRepo.findById(request.casaMadreId()).orElseThrow());

        Concessionario saved = concessionarioRepo.save(concessionario);
        return entityMapper.toConcessionarioResponse(saved);
    }

    @Transactional
    public void delete(Long id) {
        Concessionario concessionario = concessionarioRepo.findById(id).orElseThrow();

        if (!concessionario.getClienti().isEmpty()) {
            throw new IllegalArgumentException("Non è possibile eliminare il concessionario " + id +
                    " perché ha clienti associati");
        }
        concessionarioRepo.deleteById(id);
    }

    @Transactional
    public List<ConcessionarioResponse> findConcessionariByCasaMadreRagioneSociale(String ragioneSociale) {
        List<Concessionario> concessionari = concessionarioRepo.findConcessionariByCasaMadreRagioneSociale(ragioneSociale);
        return concessionari.stream().map(entityMapper::toConcessionarioResponse).toList();
    }

    @Transactional
    public List<ConcessionarioResponse> findConcessionariSopraMedia() {
        List<Concessionario> concessionari = concessionarioRepo.findConcessionariSopraMedia();
        return concessionari.stream().map(entityMapper::toConcessionarioResponse).toList();
    }
}
