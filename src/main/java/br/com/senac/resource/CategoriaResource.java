package br.com.senac.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.senac.domain.Categoria;
import br.com.senac.service.CategoriaService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
//	@RequestMapping(method=RequestMethod.GET)
//	public String testar() {
//		return "Está funcionando!";
//	}
	
	//Retorna todos objs Categoria
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Categoria>> listarCategorias(){
		List<Categoria> listarCategorias = service.listarCategorias();
		return ResponseEntity.ok().body(listarCategorias);
	}
	
	//Retorna obj Categoria passando ID como param
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id){
		Categoria objCategoria = service.findById(id);
		return ResponseEntity.ok().body(objCategoria);
	}
	
	//Registra um novo obj Categoria
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Categoria objCategoria){
		objCategoria = service.inserir(objCategoria);
		//Vamos montar a URL da resposta da categoria inserida
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objCategoria.getId()).toUri();
		//Código HTTP de Criação de Obj
		return ResponseEntity.created(uri).build();
	}
	
	//Alterar um obj Categoria
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public ResponseEntity<Categoria> alterar(@RequestBody Categoria objCategoria, @PathVariable Integer id) throws ObjectNotFoundException{
		
		objCategoria = service.alterar(objCategoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objCategoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Deletar um obj Categoria
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable Integer id) throws ObjectNotFoundException{
		service.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
