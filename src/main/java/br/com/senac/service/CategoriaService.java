package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.domain.Categoria;
import br.com.senac.repository.CategoriaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository repoCategoria;

	public List<Categoria> listarCategorias() {
		return repoCategoria.findAll();
	}
	
	public Categoria findById(Integer categoriaId){
		return repoCategoria.findById(categoriaId).get();
	}

	public Categoria inserir(Categoria objCategoria) {
		return repoCategoria.save(objCategoria);
	}

	public Categoria alterar(Categoria objCategoriaAlterado) throws ObjectNotFoundException{
		Categoria objCategoria = findById(objCategoriaAlterado.getId());
		objCategoria.setId(objCategoriaAlterado.getId());
		objCategoria.setNome(objCategoriaAlterado.getNome());
		return repoCategoria.save(objCategoria);
	}

	public void excluir(Integer id) {
		repoCategoria.deleteById(id);
	}

}
