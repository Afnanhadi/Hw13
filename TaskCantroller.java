package com.example.hw13.taskCantroller;

import com.example.hw13.ApiResponse.ApiResponse;
import com.example.hw13.Task.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskCantroller {
    ArrayList<Task> tasks=new ArrayList<>();
    @GetMapping("/get")
    public ArrayList<Task> getTasks(){
        return tasks;
    }
    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody  Task task){
        tasks.add(task);
        return new ApiResponse(" Task Add");
    }
    @PutMapping("/updet/{index}")
    public ApiResponse updetTask(@PathVariable int index, @RequestBody Task task){
        tasks.set(index,task);
        return new ApiResponse("Task upset");
    }

    @DeleteMapping("/delet/{index}")
    public ApiResponse deletTask(@PathVariable int index){
        tasks.remove(index);
        return new ApiResponse("Task Delete");
    }
    @PutMapping("/updet/Status/{index}")
    public ApiResponse updetStatus(@PathVariable int index){
        for (Task task: tasks) {
            if (tasks.get(index).getStatus().equals("done")) {
                task.setStatus("not done");
            }else { task.setStatus("done");}
        }
        return  new ApiResponse("Change the task status");
    }
   @GetMapping("/Search/{title}")
    public ApiResponse  getSearch(@PathVariable String title){
        ArrayList<Task> titles=new ArrayList<>();

        for (Task task: tasks){
            if(task.getTitle().equals(title)){
                titles.add(task);
            }
        }
        return new ApiResponse("Search title"+titles);

    }
}
