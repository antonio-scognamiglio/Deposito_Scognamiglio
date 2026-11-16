package com.gestioneconcessionari.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestioneconcessionari.dto.request.ClienteRequest;
import com.gestioneconcessionari.dto.response.ClienteResponse;
import com.gestioneconcessionari.entity.Cliente;
import com.gestioneconcessionari.mapper.EntityMapper;
import com.gestioneconcessionari.repository.ClienteRepository;
import com.gestioneconcessionari.repository.ConcessionarioRepository;

@Service
public class ClienteService {

    private final EntityMapper entityMapper;
    private final ClienteRepository clienteRepo;
    private final ConcessionarioRepository concessionarioRepo;

    public ClienteService(ClienteRepository clienteRepo, ConcessionarioRepository concessionarioRepo,
            EntityMapper entityMapper) {
        super();
        this.clienteRepo = clienteRepo;
        this.concessionarioRepo = concessionarioRepo;
        this.entityMapper = entityMapper;
    }

    @Transactional
    public List<ClienteResponse> findAll() {
        List<Cliente> clienti = clienteRepo.findAll();
        return clienti.stream().map(entityMapper::toClienteResponse).toList();
    }

    @Transactional
    public ClienteResponse create(ClienteRequest request) {
        if (!concessionarioRepo.existsById(request.concessionarioId())) {
            throw new IllegalArgumentException("Concessionario con id " + request.concessionarioId() + " non trovato");
        }

        Cliente cliente = new Cliente();
        cliente.setNome(request.nome());
        cliente.setCognome(request.cognome());
        cliente.setEmail(request.email());
        cliente.setTelefono(request.telefono());
        cliente.setDataRegistrazione(LocalDateTime.now());
        cliente.setConcessionario(concessionarioRepo.findById(request.concessionarioId()).orElseThrow());

        Cliente saved = clienteRepo.save(cliente);
        return entityMapper.toClienteResponse(saved);
    }

    @Transactional
    public ClienteResponse findById(Long id) {
        Cliente cliente = clienteRepo.findById(id).orElseThrow();
        return entityMapper.toClienteResponse(cliente);
    }

    @Transactional
    public ClienteResponse update(Long id, ClienteRequest request) {
        Cliente cliente = clienteRepo.findById(id).orElseThrow();

        if (!concessionarioRepo.existsById(request.concessionarioId())) {
            throw new IllegalArgumentException("Concessionario con id " + request.concessionarioId() + " non trovato");
        }

        cliente.setNome(request.nome());
        cliente.setCognome(request.cognome());
        cliente.setEmail(request.email());
        cliente.setTelefono(request.telefono());
        cliente.setConcessionario(concessionarioRepo.findById(request.concessionarioId()).orElseThrow());

        Cliente saved = clienteRepo.save(cliente);
        return entityMapper.toClienteResponse(saved);
    }

    @Transactional
    public void delete(Long id) {
        if (!clienteRepo.existsById(id)) {
            throw new IllegalArgumentException("Cliente con id " + id + " non trovato");
        }
        clienteRepo.deleteById(id);
    }

    @Transactional
    public List<ClienteResponse> findClientiByConcessionarioId(Long id) {
        List<Cliente> clienti = clienteRepo.findClientiByConcessionarioId(id);
        return clienti.stream().map(entityMapper::toClienteResponse).toList();
    }

    @Transactional
    public List<ClienteResponse> findClientiByNomeECognome(String nome, String cognome) {
        List<Cliente> clienti = clienteRepo.findClientiByNomeECognome(nome, cognome);
        return clienti.stream().map(entityMapper::toClienteResponse).toList();
    }
}
