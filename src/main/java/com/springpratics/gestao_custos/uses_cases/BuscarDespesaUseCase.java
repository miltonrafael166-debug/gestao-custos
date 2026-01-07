package com.springpratics.gestao_custos.uses_cases;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpratics.gestao_custos.entity.Despesa;
import com.springpratics.gestao_custos.repository.DespesaRepository;

@Service
public class BuscarDespesaUseCase {
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	
	public List<Despesa> execute(String email, LocalDate date) {
		List<Despesa> despesas;
		if (date != null) {
			despesas = despesaRepository.findByEmailAndData(email, date);
		} else {
			despesas = despesaRepository.findByEmail(email);
		}
		return despesas;	
	}
	
}
