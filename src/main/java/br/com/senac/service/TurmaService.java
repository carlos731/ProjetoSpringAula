package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	//Cadastrar alunos
	public Turma salvar(Turma turma) {
		return turmaRepository.save(turma);
	}
	//Buscar todos alunos
	public List<Turma> buscarTodasTurmas(){
		return turmaRepository.findAll();
	}
	//Buscar Aluno por id
	public Turma buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Turma> turma = turmaRepository.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(1L, "turma não encontrado"));
	}
	//Deletar Aluno
	public void deletarPorId(Integer id) {
        Optional<Turma> turma = turmaRepository.findById(id);
        turmaRepository.deleteById(id);
    }
	//Atualizar Aluno
	public Turma atualizarPorId(Integer id, Turma o) {
		Turma turma = buscarPorId(id);
		turma.setNome(o.getNome());
		return turmaRepository.save(turma);
	}
	
	//Atualizar do Struct
	public Turma salvarAlteracao(Turma turmaAlterada) {
		Turma turma = buscarPorId(turmaAlterada.getId());
		turma.setNome(turmaAlterada.getNome());
		return salvar(turma);
	}
	
}
