package no.hvl.dat250.rest.todos;

/**
 * Rest-Endpoint for todos.
 */
@RestController
public class TodoController {

    private final Todos todos = new Todos();

    @GetMapping("/todos")
	public Counters getTodos() {
		return todo;
	}

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todos.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo createTodo(@RequestBody Todo todo) {
        return todos.create(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodoById(@PathVariable Long id, @RequestBody Todo todo) {
        return todos.updateById(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public Todo deleteTodoById(@PathVariable Long id) {
        return todos.deleteById(id);
    }

    
  
    public static final String TODO_WITH_THE_ID_X_NOT_FOUND = "Todo with the id %s not found!";
}
