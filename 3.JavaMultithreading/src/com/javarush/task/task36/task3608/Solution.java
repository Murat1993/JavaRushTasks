package com.javarush.task.task36.task3608;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.MainModel;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;


/*
1. Распредели методы по классам MVC:

public void onOpenUserEditForm(long userId) {
…loadUserById(userId);
…refresh(…getModelData());
}

public void fireEventOpenUserEditForm(long id) {
…onOpenUserEditForm(id);
}

public void loadUserById(long userId) {
User user = userService.getUsersById(userId);
…setActiveUser(user);
}

!!!! Пользователь видит Вью со списком пользователей,
нажимает на одного из них, запрос идет на сервер,
выгребаем новые данные и отображаем другую Вью, которая относится к одному выбранному пользователю.
Учти это при реализации этого задания.

2. Добавь в метод main открытие формы редактирования для
пользователя с id=126 перед вызовом метода fireEventShowDeletedUsers().

3. Добавь в интерфейс Model метод, который ты поместил в Модель,
реализуй его в FakeModel: выброси UnsupportedOperationException.

2. Добавь в метод main открытие формы редактирования
для пользователя с id=126 перед вызовом метода fireEventShowDeletedUsers().

* */

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView = new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireEventShowAllUsers();
        usersView.fireEventOpenUserEditForm(126);
        usersView.fireEventShowDeletedUsers();
    }
}