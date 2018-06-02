package hello.Controllers;

import hello.Models.Todo;
import hello.Services.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todos")
    public ModelAndView Get() {
        Page<Todo> todos = service.findAll(0, Integer.MAX_VALUE);
        ModelAndView mav = new ModelAndView("todos/index");
        mav.addObject("todos", todos);
        return mav;
    }


    @GetMapping("/todos/{id}")
    public ModelAndView GetById(@PathVariable UUID id) {
        Optional<Todo> todo = service.find(id);
        ModelAndView mav = new ModelAndView("todos/edit");
        mav.addObject("todo", todo.get());
        return mav;
    }

    @GetMapping("/todos/new")
    public ModelAndView NewView() {
        return new ModelAndView("todos/new");
    }

    @PutMapping("/todos")
    public ModelAndView CreateView(@RequestBody Todo todo) {
        Todo save = service.save(todo);

        if(save == null) {
            return new ModelAndView();

        }

        return new ModelAndView("redirect:/todos/index");
    }
}
