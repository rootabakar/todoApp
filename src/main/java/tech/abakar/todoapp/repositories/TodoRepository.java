package tech.abakar.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.abakar.todoapp.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
