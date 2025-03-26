package com.exemplo.apifatura.service;

import com.exemplo.apifatura.model.Fatura;
import com.exemplo.apifatura.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaturaService {
   private final FaturaRepository faturaRepository;
    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> listar() {
        return faturaRepository.findAll();
    }

    public Fatura salvar(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

}
