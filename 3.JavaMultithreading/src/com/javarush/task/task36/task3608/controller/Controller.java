package com.javarush.task.task36.task3608.controller;

/*
* 1. Создай пакет controller, в котором создай класс Controller.
*
Этот класс будет получать запрос от клиента, оповещать Модель об этом,
а Модель, в свою очередь, будет обновлять ModelData.

2. Добавь в контроллер поле Model model вместе с сеттером.

3. В контроллере создай публичный метод void onShowAllUsers(),
который должен обратиться к модели и инициировать загрузку пользователей.

4. Создай пакет view. В нем создай интерфейс View.

5. В интерфейс View добавь два метода:
void refresh(ModelData modelData) и void setController(Controller controller)*/

import com.javarush.task.task36.task3608.model.Model;

public class Controller {
    private Model model;

    public void onShowAllUsers() {
        model.loadUsers();
    }

    public void setModel(Model model) {
        this.model = model;
    }
}
