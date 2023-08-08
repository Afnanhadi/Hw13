package com.example.hw13.Task;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String ID;
    private String title;
    private String description;
    public String Status;

}
