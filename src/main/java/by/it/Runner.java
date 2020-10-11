package by.it;

import by.it.dao.UserDao;
import by.it.model.User;


public class Runner {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        userDao.create(
                User.builder()
                        .firstName("Верезубов")
                        .lastName("Алексей")
                        .email("zverovik@yahoo.com")
                        .build());

        userDao.create(
                User.builder()
                        .firstName("Гурчунов")
                        .lastName("Роман")
                        .email("gurchunov-1997@mail.ru")
                        .build());




        User userFind1 = userDao.findByID(2L);

        System.out.println(userFind1.getFirstName() + " " + userFind1.getLastName() + " " + userFind1.getEmail());

    }

}

