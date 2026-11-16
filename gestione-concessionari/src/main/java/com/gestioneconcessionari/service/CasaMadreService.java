package com.gestioneconcessionari.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestioneconcessionari.dto.request.CasaMadreRequest;
import com.gestioneconcessionari.dto.response.CasaMadreResponse;
import com.gestioneconcessionari.entity.CasaMadre;
import com.gestioneconcessionari.mapper.EntityMapper;
import com.gestioneconcessionari.repository.CasaMadreRepository;

@Service
public class CasaMadreService {

    private final EntityMapper entityMapper;
    private final CasaMadreRepository casaMadreRepo;

    public CasaMadreService(CasaMadreRepository casaMadreRepo, EntityMapper entityMapper) {
        super();
        this.casaMadreRepo = casaMadreRepo;
        this.entityMapper = entityMapper;
    }

    @Transactional
    public List<CasaMadreResponse> findAll() {
        List<CasaMadre> caseMadri = casaMadreRepo.findAll();
        return caseMadri.stream().map(entityMapper::toCasaMadreResponse).toList();
    }

    @Transactional
    public CasaMadreResponse create(CasaMadreRequest request) {
        CasaMadre casaMadre = new CasaMadre();
        casaMadre.setRagioneSociale(request.ragioneSociale());
        casaMadre.setSedeLegale(request.sedeLegale());
        casaMadre.setPaese(request.paese());
        casaMadre.setAnnoFondazione(request.annoFondazione());
        casaMadre.setFatturatoAnnuo(request.fatturatoAnnuo());

        CasaMadre saved = casaMadreRepo.save(casaMadre);
        return entityMapper.toCasaMadreResponse(saved);
    }

    @Transactional
    public CasaMadreResponse findById(Long id) {
        CasaMadre casaMadre = casaMadreRepo.findById(id).orElseThrow();
        return entityMapper.toCasaMadreResponse(casaMadre);
    }

    @Transactional
    public CasaMadreResponse update(Long id, CasaMadreRequest request) {
        CasaMadre casaMadre = casaMadreRepo.findById(id).orElseThrow();

        casaMadre.setRagioneSociale(request.ragioneSociale());
        casaMadre.setSedeLegale(request.sedeLegale());
        casaMadre.setPaese(request.paese());
        casaMadre.setAnnoFondazione(request.annoFondazione());
        casaMadre.setFatturatoAnnuo(request.fatturatoAnnuo());

        CasaMadre saved = casaMadreRepo.save(casaMadre);
        return entityMapper.toCasaMadreResponse(saved);
    }

    @Transactional
    public void delete(Long id) {
        CasaMadre casaMadre = casaMadreRepo.findById(id).orElseThrow();

        if (!casaMadre.getConcessionari().isEmpty()) {
            throw new IllegalArgumentException("Non è possibile eliminare la Casa Madre " + id +
                    " perché ha concessionari associati");
        }
        casaMadreRepo.deleteById(id);
    }
}
