package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Curso;
import br.com.senac.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	//Buscar todos
	public List<Curso> buscarTodos(){
		return cursoRepository.findAll();
	}

	//Buscar por id
	public Curso buscarPorId(Integer id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		return curso.orElseThrow(() -> new ObjectNotFoundException(1L, "Curso não encontrado"));
	}
	
	//cadastrar curso
	public Curso salvar(Curso curso) {
		return cursoRepository.save(curso);
	}
	//Deletar Curso
	public void deletarPorId(Integer id) {
		Optional<Curso> curso = cursoRepository.findById(id);
		cursoRepository.deleteById(id);
	}
	//Atualizar Curso
	public Curso atualizarPorId(Integer id, Curso obj) {
		Curso curso = buscarPorId(id);
		curso.setNome(obj.getNome());
		return cursoRepository.save(curso);
	}
	//Atualizar Curso
	public Curso atualizarCurso(Curso cursoAlterado) {
		Curso curso = buscarPorId(cursoAlterado.getId());
		curso.setNome(cursoAlterado.getNome());
		return salvar(curso);
	}
}
