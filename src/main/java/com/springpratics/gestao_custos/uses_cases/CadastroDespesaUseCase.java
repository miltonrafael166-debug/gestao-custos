package com.springpratics.gestao_custos.uses_cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpratics.gestao_custos.entity.Despesa;
import com.springpratics.gestao_custos.repository.DespesaRepository;

@Service
public class CadastroDespesaUseCase {

	@Autowired
	private DespesaRepository despesaRepository;

	public Despesa execute(Despesa despesa) {
		if (despesa.getCategoria() == null || despesa.getData() == null || despesa.getDescricao() == null 
				|| despesa.getEmail() == null || despesa.getValor() == null) {
			throw new IllegalArgumentException("U need write the fields");
		} else {
		despesa = despesaRepository.save(despesa);
		return despesa;
		}
	}

}
