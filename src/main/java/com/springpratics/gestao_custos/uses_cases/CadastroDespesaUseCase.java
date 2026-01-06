package com.springpratics.gestao_custos.uses_cases;

import org.springframework.stereotype.Service;

import com.springpratics.gestao_custos.entity.Despesa;

@Service
public class CadastroDespesaUseCase {
	
	public void execute(Despesa despesa) {
		System.out.println(despesa);

	}

}
