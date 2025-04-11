package cit.task.TaskManagerApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cit.task.TaskManagerApplication.entities.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task,Integer>{

}
