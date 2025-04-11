package cit.task.TaskManagerApplication.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String title;

	@Enumerated(EnumType.STRING)
	private Status status = Status.PENDING;

	public enum Status {
		PENDING, COMPLETED
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(int id, String title, Status status) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
	}

}
