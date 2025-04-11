package cit.task.TaskManagerApplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cit.task.TaskManagerApplication.entities.Task;
import cit.task.TaskManagerApplication.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository repo;

	public Task addTask(Task task) {
		return repo.save(task);
	}

	public void removeTask(int id) {
		repo.deleteById(id);
	}

	public List<Task> getAllTasks() {
		return repo.findAll();
	}

	public Task markCompleted(int id) {
		Task task = repo.findById(id).orElseThrow();
		task.setStatus(Task.Status.COMPLETED);
		return repo.save(task);
	}

	public Task getTaskById(int id) {
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
	}

	public Task updateTaskTitle(int id, String newTitle) {
		Task task = repo.findById(id).orElseThrow(() -> new RuntimeException("Task not found with ID: " + id));
		task.setTitle(newTitle);
		return repo.save(task);
	}

}
