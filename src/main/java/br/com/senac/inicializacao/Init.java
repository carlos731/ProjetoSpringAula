package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.service.AlunoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private AlunoService alunoService;
	
	//@Autowired
	//AlunoRepository repo;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Jose");
		
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		
		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		
		//repo.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
		
		for(Aluno aluno : listaAlunos) {
			System.out.println(aluno.getNome());
		}
		
		//Busca por id
		Aluno aluno4 = alunoService.buscarPorId(1);
		
		System.out.println(aluno4.getNome());
		
		//deleção por id
		alunoService.deletarPorId(2);
	
		//Atualizar por id
		//aluno1.setNome("Carlos");
		//alunoService.atualizarPorId(1, aluno1);
		//
		//System.out.println("Teste Atualização: " + aluno1.getNome());
		
		Aluno alunoAlterado = new Aluno();
		alunoAlterado.setId(1);
		alunoAlterado.setNome("Lucas Silva");
		
		alunoService.salvarAlteracao(alunoAlterado);
		
		
	}

}
