package com.example.librarymanagementsystem.Models;

import com.example.librarymanagementsystem.Enums.Status;

public abstract class Entity {
    protected final int ID;
    private static int counter = 0;
    protected String name;
    private Status status;

    public Entity(String name) {
        this.ID = counter++;
        this.name = name;
        this.status = Status.ACTIVE;
    }
}
