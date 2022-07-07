package com.ali.todoseca;

public class ToDoItem {

    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    private String Title;
    private String Description;
    private boolean isCompleted;


    public ToDoItem()
    {
        ID = 0;
        Title = "Unknown";
        Description = "Nothing....";
        isCompleted = false;
    }
    public ToDoItem(int id, String title, String desc, boolean b)
    {
        ID = id;
        Title = title;
        Description = desc;
        isCompleted = b;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "ID=" + ID +
                ", Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
