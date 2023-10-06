package no.hvl.dat250.rest.todos;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest-Endpoint for todos.
 */
@RestController
public class TodoController {
    private Long idCounter = 0L;
    private List<Todo> todos = new ArrayList<>();

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todos;
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo) {
        todo.setId(++idCounter);
        todos.add(todo);
        return todo;
    }

    @GetMapping("/todos/{id}")
    public Object getTodoById(@PathVariable Long id) {
        // loops through list until i find the todo with the id
        for (Todo todo : todos) {

            if (todo.getId().equals(id)) {
                return todo;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(TODO_WITH_THE_ID_X_NOT_FOUND, id));
    }

    @PutMapping("/todos/{id}")
    public Object updateTodoById(@PathVariable Long id) {
        // loops through list until i find the todo with the id

        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                todo.setDescription("updated description");
                todo.setSummary("updated summary");
                return todo;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(TODO_WITH_THE_ID_X_NOT_FOUND, id));
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodoById(@PathVariable Long id) {
        // loops through list until i find the todo with the id
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                todos.remove(todo);
            }
        }
    }

    public static final String TODO_WITH_THE_ID_X_NOT_FOUND = "Todo with the id %s not found!";
}
/**
@RestController
class EmployeeController {

    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return repository.save(newEmployee);
    }

    // Single item

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
*/