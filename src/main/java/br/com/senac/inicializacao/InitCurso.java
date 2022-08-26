package br.com.senac.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Curso;
import br.com.senac.service.CursoService;


@Component
public class InitCurso implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private CursoService cursoService;
	
	//@Autowired
	//AlunoRepository repo;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Curso curso1 = new Curso();
		curso1.setNome("Matemática");
		
		Curso curso2 = new Curso();
		curso2.setNome("Fisica");
		
		Curso curso3 = new Curso();
		curso3.setNome("Quimica");
		
		//Teste salvar no banco
		cursoService.salvar(curso1);
		cursoService.salvar(curso2);
		cursoService.salvar(curso3);
		
		List<Curso> listaCursos = cursoService.buscarTodos();
		
		//repo.saveAll(Arrays.asList(aluno1, aluno2, aluno3));
		
		//Exibir nomes das turmas
		for(Curso curso : listaCursos) {
			System.out.println(curso.getNome());
		}
		
		//Buscar por id
		Curso busca = cursoService.buscarPorId(2);
		
		System.out.println(busca.getNome());
		
		//deleção por id
		cursoService.deletarPorId(3);
		
		//Atualização por id
		Curso cursoAlterado = new Curso();
		cursoAlterado.setId(2);
		cursoAlterado.setNome("Portugues");
		
		cursoService.salvar(cursoAlterado);
		
	}
}
