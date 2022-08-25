package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Curso;
import br.com.senac.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	//Buscar todos
	public List<Curso> buscarPorId(){
		return cursoRepository.findAll();
	}

	//Buscar por id
	public Curso buscarPorId(Integer id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.orElseThrow(() -> new ObjectNotFoundException(1L, "Curso não encontrado"));
	}
	
	//cadastrar curso
	public Curso salvarCurso(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	public void deletarCurso(Curso curso) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return cursoRepository.deleteById(id);
	}
}
