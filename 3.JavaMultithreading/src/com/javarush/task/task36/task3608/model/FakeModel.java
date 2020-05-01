package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.LinkedList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> myList = new LinkedList<>();
        myList.add(new User("A", 1, 1));
        myList.add(new User("B", 2, 1));
        modelData.setUsers(myList);
    }
}