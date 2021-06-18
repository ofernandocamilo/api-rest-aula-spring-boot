package br.com.senac.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.domain.Categoria;
import br.com.senac.repository.CategoriaRepository;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Categoria categoria1 = new Categoria();
		Categoria categoria2 = new Categoria();		
		Categoria categoria3 = new Categoria();
		Categoria categoria4 = new Categoria();
		Categoria categoria5 = new Categoria();
		
		categoria1.setId(1);
		categoria1.setNome("Rock and Roll");
		
		categoria2.setId(2);
		categoria2.setNome("Blues");
		
		categoria3.setId(3);
		categoria3.setNome("Jazz");
		
		categoria4.setId(4);
		categoria4.setNome("Samba");
		
		categoria5.setId(5);
		categoria5.setNome("Pop");
		
		categoria1 = categoriaRepository.save(categoria1);
		categoria2 = categoriaRepository.save(categoria2);
		categoria3 = categoriaRepository.save(categoria3);
		categoria4 = categoriaRepository.save(categoria4);
		categoria5 = categoriaRepository.save(categoria5);
	}
}
