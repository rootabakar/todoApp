package tech.abakar.todoapp.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tech.abakar.todoapp.entities.Todo;
import tech.abakar.todoapp.repositories.TodoRepository;

import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {

    TodoRepository todoRepository;

    @GetMapping("/")
    public String index(Model model){
        List<Todo> all = todoRepository.findAll();
        model.addAttribute("todos", all);
        return "index";
    }

    @PostMapping("/add")
    public String add(@RequestParam("todo") String todo, Model model, RedirectAttributes redirectAttributes){
        Todo build = Todo.builder()
                .id(null)
                .title(todo)
                .completed(false)
                .build();
        todoRepository.save(build);
        redirectAttributes.addFlashAttribute("msg", "Todo added successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes){
        todoRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("msg", "Todo deleted successfully");
        return "redirect:/";
    }

}
