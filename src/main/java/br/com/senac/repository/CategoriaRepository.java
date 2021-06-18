package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository <Categoria, Integer>  {

}