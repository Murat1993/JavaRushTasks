package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Arnold", 1, 10));
        users.add(new User("Arnold", 1, 10));
        users.add(new User("Arnold", 1, 10));
        users.add(new User("Arnold", 1, 10));

        modelData.setUsers(users);
    }
}