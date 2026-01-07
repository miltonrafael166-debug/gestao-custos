package com.springpratics.gestao_custos.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springpratics.gestao_custos.entity.Despesa;
import com.springpratics.gestao_custos.exceptions.ErrorMessage;
import com.springpratics.gestao_custos.uses_cases.CadastroDespesaUseCase;

@RequestMapping("/gestao")
@RestController
public class GestaoDespesaController {

	@Autowired
	CadastroDespesaUseCase cadastroDespesaUseCase;

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Despesa despesa) {
		try {
			var result = cadastroDespesaUseCase.execute(despesa);
			return ResponseEntity.ok(result);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.status(400).body(new ErrorMessage(e.getMessage(), "invalid params"));
		}
	}
	
	@GetMapping("/{email}")
	public void findByEmailAndDate(@PathVariable String email, @RequestParam(required = false) LocalDate date) {
		System.out.println(email);
		System.out.println(date);
	}

}
