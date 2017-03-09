package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/*1.4. Уже интересно посмотреть, что же получилось.

Добавь в UsersView публичный метод void fireEventShowAllUsers(), который будет эмулировать событие клиента.

Обратись к контроллеру и вызови его нужный метод для отображения всех пользователей.

5. Класс Solution будет эмулятором пользователя. Открой класс Solution, стань на красный метод,

с помощью горячих клавиш Идеи создай проперти(поле) для usersView.

Нужен только сеттер. Если у тебя создался геттер, то удали его.

6. Запусти main. Упс, ничего не вывело :(

Это получилось потому, что данные пришли с сервера, обновились в ModelData, но Вью ничего о них не знает.

Вью сама не умеет себя обновлять. Это делает Контроллер.

Пойди в контроллер и добавь обновление данных во Вью.

Напомню, данные хранятся в Модели.*/

public class UsersView implements View {
    private Controller controller;

    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("All users:");
        for (User user : modelData.getUsers()) {
            System.out.println("\t" + user);
        }
        System.out.println("==================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }
}
