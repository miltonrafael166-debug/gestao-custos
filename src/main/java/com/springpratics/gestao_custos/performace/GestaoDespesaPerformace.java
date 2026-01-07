package com.springpratics.gestao_custos.performace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpratics.gestao_custos.entity.Despesa;
import com.springpratics.gestao_custos.repository.DespesaRepository;

@RequestMapping("/gestao/performace")
@RestController
@EnableCaching
public class GestaoDespesaPerformace {
	
	@Autowired
	DespesaRepository repository;
	
	@GetMapping("/sem-paginacao")
	public ResponseEntity<List<Despesa>> listarSemPaginacao() {
		Long inicio = System.currentTimeMillis();
		var despesas = repository.findAll();
		Long fim = System.currentTimeMillis();
		
		System.out.println("tempo de resposta: " +(fim - inicio)+ "ms");
		return ResponseEntity.ok(despesas);	
	}
	
	@GetMapping("/com-paginacao")
	public ResponseEntity<Page<Despesa>> listarComPaginacao(Pageable pageable) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		var despesas = repository.findAll(pageable);
		stopWatch.stop();
		System.out.println("tempo de resposta: " +stopWatch.getTotalTimeMillis()+ "ms");
		return ResponseEntity.ok(despesas);	
	}
	
	@GetMapping("/com-paginacao/{email}")
	public ResponseEntity<Page<Despesa>> listarComPaginacao(@PathVariable String email, Pageable pageable) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		var despesas = repository.findByEmail(email, pageable);
		stopWatch.stop();
		System.out.println("tempo de resposta: " +stopWatch.getTotalTimeMillis()+ "ms");
		return ResponseEntity.ok(despesas);	
	}
	
	@GetMapping("/cache/{email}")
	public ResponseEntity<Page<Despesa>> cacheComPaginacao(@PathVariable String email, Pageable pageable) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		var despesas = repository.findByEmail(email, pageable);
		stopWatch.stop();
		System.out.println("tempo de resposta: " +stopWatch.getTotalTimeMillis()+ "ms");
		return ResponseEntity.ok(despesas);	
	}
}

