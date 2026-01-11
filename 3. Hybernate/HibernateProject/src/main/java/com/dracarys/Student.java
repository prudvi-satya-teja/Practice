package com.dracarys;

public class Student {

    int id;
    String name;
    int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    @Override
    public String toString() {
        return "com.dracarys.Student{" + "id=" + id + ", name=" + name + ", score=" + score + '}';
    }
}
