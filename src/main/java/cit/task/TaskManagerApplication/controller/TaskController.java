package cit.task.TaskManagerApplication.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cit.task.TaskManagerApplication.entities.Task;
import cit.task.TaskManagerApplication.services.TaskService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private TaskService service;

	@PostMapping
	public Task addTask(@RequestBody Task task) {
        logger.info("Adding new task: {}", task.getTitle());

		return service.addTask(task);
	}

	@GetMapping
	public List<Task> getTasks() {
		return service.getAllTasks();
	}

	@DeleteMapping("/{id}")
	public void removeTask(@PathVariable int id) {
		service.removeTask(id);
	}

	@PutMapping("/{id}/complete")
	public Task markAsComplete(@PathVariable int id) {
		return service.markCompleted(id);
	}

	@GetMapping("/{id}")
	public Task getTaskById(@PathVariable int id) {
		 logger.info("Fetching task with ID: {}", id);
		return service.getTaskById(id);
	}

	@PutMapping("/{id}/title")
	public Task updateTitle(@PathVariable int id, @RequestBody Map<String, String> body) {
		String newTitle = body.get("title");
		return service.updateTaskTitle(id, newTitle);
	}

}
