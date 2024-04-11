package tech.abakar.todoapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.abakar.todoapp.entities.Todo;
import tech.abakar.todoapp.repositories.TodoRepository;

@SpringBootApplication
public class TodoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

    @Bean
    CommandLineRunner start(TodoRepository todoRepository){
        return args -> {
            todoRepository.save(Todo.builder().id(null).title("Todo 1").completed(false).build());
            todoRepository.save(Todo.builder().id(null).title("Todo 2").completed(false).build());
            todoRepository.save(Todo.builder().id(null).title("Todo 3").completed(false).build());
            todoRepository.save(Todo.builder().id(null).title("Todo 4").completed(false).build());
            todoRepository.save(Todo.builder().id(null).title("Todo 5").completed(false).build());
            todoRepository.save(Todo.builder().id(null).title("Todo 6").completed(false).build());
            todoRepository.save(Todo.builder().id(null).title("Todo 7").completed(false).build());
        };
    }
}
