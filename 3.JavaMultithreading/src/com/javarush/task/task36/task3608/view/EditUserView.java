package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/*
2. Аналогично UsersView создай EditUserView.
Логика метода refresh:
2.1. Вывести в консоль «User to be edited:«.
2.2. С новой строки вывести табуляцию и активного пользователя.
2.3. С новой строки вывести разделитель «===================================================».

* */

public class EditUserView implements View {
    private Controller controller;


    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited:");
        System.out.println("\t" + modelData.getActiveUser());
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
