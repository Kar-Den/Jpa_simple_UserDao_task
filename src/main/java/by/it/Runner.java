package by.it;

import by.it.dao.UserDao;
import by.it.model.User;

import java.util.List;


public class Runner {

    public static void main(String[] args) {

        UserDao userDao = new UserDao();

        userDao.create(User.builder()
                .firstName("Верезубов")
                .lastName("Алексей")
                .email("zverovik@yahoo.com").build());
        userDao.create(User.builder()
                .firstName("Роман")
                .lastName("Гурчунов")
                .email("gurchunov-1997@mail.ru").build());
        userDao.create(User.builder()
                .firstName("Александр")
                .lastName("Зенькович")
                .email("sanyazenkovgomel@gmail.com").build());
        userDao.create(User.builder()
                .firstName("Татьяна")
                .lastName("Ковганко")
                .email("Dr.lisa217@gmail.com").build());
        userDao.create(User.builder()
                .firstName("Владимир")
                .lastName("Петрушенко")
                .email("petrush@tut.by").build());
        userDao.create(User.builder()
                .firstName("Иван")
                .lastName("Семёнов")
                .email("semen_gen@tut.by").build());
        userDao.create(User.builder()
                .firstName("Игорь")
                .lastName("Ханануев")
                .email("alatair8@mail.ru").build());
        userDao.create(User.builder()
                .firstName("Андрей")
                .lastName("Чернушевич")
                .email("a.charnushevich@gmail.com").build());
        userDao.create(User.builder()
                .firstName("Павел")
                .lastName("Унуковский")
                .email("paulu@mail.ru").build());
        userDao.create(User.builder()
                .firstName("Антон")
                .lastName("Снежков")
                .email("anton_sniazhkou1@epam.com").build());


        User userFindById = userDao.findByID(10L);
        System.out.println(userFindById.getFirstName() + " " + userFindById.getLastName() + " " + userFindById.getEmail());

        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
        }


    }

}

