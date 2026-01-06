package com.springpratics.gestao_custos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpratics.gestao_custos.entity.Despesa;
import com.springpratics.gestao_custos.uses_cases.CadastroDespesaUseCase;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {
	
	@Autowired
	CadastroDespesaUseCase cadastroDespesaUseCase;
	
	@PostMapping("/create")
	public void create(@RequestBody Despesa despesa) {
		cadastroDespesaUseCase.execute(despesa);
	}

}
