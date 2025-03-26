package com.exemplo.apifatura.controller;

import com.exemplo.apifatura.model.Fatura;
import com.exemplo.apifatura.repository.FaturaRepository;
import com.exemplo.apifatura.service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;
    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping
    public List<Fatura> listar() {
        return faturaService.listar();
    }

    @PostMapping
    public ResponseEntity<Fatura> salvar(@Valid @RequestBody Fatura fatura) {
        Fatura novaFatura = faturaService.salvar(fatura);
        return ResponseEntity.ok(novaFatura);
    }
}
