package tasks.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;

import tasks.dao.TaskDao;
import tasks.modelo.Task;

@Controller
public class TaskController {

	private final TaskDao dao;
	
	@Autowired
	public TaskController(TaskDao dao){
//		dao = new TaskDao();
		this.dao = dao;
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
//		return "tasks/get-tasks-ajax2";
//		return "tasks/get-tasks-ajax3";
		return "tasks/get-tasks-ajax4";
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

//	@ResponseBody
	@RequestMapping("finalizatask")
	public String finaliza(Long id, Model model) {
		dao.finaliza(id);
		model.addAttribute("task", dao.getById(id));
//		return "tasks/data-finalizada";
		return "tasks/data-finalizada2";
	}
}
