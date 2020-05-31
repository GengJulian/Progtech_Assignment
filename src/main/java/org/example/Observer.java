package org.example;

public interface Observer {
    public void update(Order itemorder,Warehouse notifier);
    public void setSubject(Subject sub);
}
