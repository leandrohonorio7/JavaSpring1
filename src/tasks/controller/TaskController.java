package tasks.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import tasks.dao.TaskDao;
import tasks.modelo.Task;

@Controller
public class TaskController {

	private final TaskDao dao;
	
	public TaskController(){
		dao = new TaskDao();
	}
	
	@RequestMapping("novastask")
	public String form(){
		return "tasks/form-tasks";
	}
	
	@RequestMapping("cadastratask")
	public String cadastra(@Valid Task task, BindingResult result){
		//TaskDao dao = new TaskDao();
		if (result.hasFieldErrors("descricao"))
			return "tasks/form-tasks";
		
		dao.inserir(task);
		
		return "tasks/task-cadastrada";
	}
	
	@RequestMapping("gettasks")
	public String lista(Model model){
		model.addAttribute("tasks", dao.getTasks());
//		return "tasks/get-tasks";
		return "tasks/get-tasks-ajax";
	}
	
	@RequestMapping("excluitask")
	public String exclui(@Valid Task task, BindingResult result){
		dao.exclui(task);
		
		//redirecionamento cliente side
		return "redirect:gettasks";
		
		//redirecionamento server side
		//return "forward:gettasks";
	}
	
	@RequestMapping("buscatask")
	public String editar(Long id, Model model){
		model.addAttribute("task", dao.getById(id));
		return "tasks/edite-task";
	}
	
	@RequestMapping("editatask")
	public String editar(Task task){	
		dao.edita(task);
		
		return "redirect:gettasks";
	}

	@RequestMapping("finalizatask")
	public void finaliza(Long id) {
		dao.finaliza(id);
	}
}
