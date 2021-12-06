package org.hzz.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Dog implements HttpSessionBindingListener {
    private String breed;

    public Dog(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("==================Value Bound==================");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }
}
