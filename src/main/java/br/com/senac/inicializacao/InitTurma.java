package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Turma;
import br.com.senac.service.TurmaService;

@Component
public class InitTurma implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private TurmaService turmaService;
	
	//@Autowired
	//AlunoRepository repo;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Turma turma1 = new Turma();
		turma1.setNome("3001");
		
		Turma turma2 = new Turma();
		turma2.setNome("3002");
		
		Turma turma3 = new Turma();
		turma3.setNome("3003");
		
		//Teste salvar no banco
		turmaService.salvar(turma1);
		turmaService.salvar(turma2);
		turmaService.salvar(turma3);
		
		List<Turma> listaTurmas = turmaService.buscarTodasTurmas();
		
		//repo.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
		
		//Exibir nomes das turmas
		for(Turma turma : listaTurmas) {
			System.out.println(turma.getNome());
		}
		
		//Buscar por id
		Turma busca = turmaService.buscarPorId(2);
		
		System.out.println(busca.getNome());
		
		//deleção por id
		turmaService.deletarPorId(3);
		
		//Atualização por id
		Turma turmaAlterada = new Turma();
		turmaAlterada.setId(1);
		turmaAlterada.setNome("3004");
		
		turmaService.salvar(turmaAlterada);
		
	}
}
