package com.mindofmachines.vegme.ui.tasks;

public class Task {
    private String title;
    private String year;
    private String month;
    private String date;
    private String time;
    private String description;

    public Task(String title, String year, String month, String date, String time, String description) {
        this.title = title;
        this.year = year;
        this.month = month;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() { return month; }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

}
