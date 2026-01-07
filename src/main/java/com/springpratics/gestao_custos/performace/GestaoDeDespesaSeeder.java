package com.springpratics.gestao_custos.performace;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springpratics.gestao_custos.entity.Despesa;
import com.springpratics.gestao_custos.repository.DespesaRepository;

@Component
public class GestaoDeDespesaSeeder implements CommandLineRunner {

	@Autowired
	DespesaRepository despesaRepository;
	
	List<Despesa> list = new ArrayList<>();
	private void sysout() {
		System.out.println("Start test of 150000 users.");
	}
	
	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i <= 1500000; i++) {
			Despesa despesa = new Despesa();
			despesa.setDescricao("gastos: " + i);
			despesa.setValor(BigDecimal.valueOf(i+2));
			despesa.setData(LocalDate.now().minusDays(i % 30));
			despesa.setCategoria("teste");
			despesa.setEmail("performace@gmail.com");
			
			list.add(despesa);
		}
		
		despesaRepository.saveAll(list);
		
		System.out.println("finish generation");
	}
	
	

}
