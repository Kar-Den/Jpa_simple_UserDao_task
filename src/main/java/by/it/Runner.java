package by.it;

import by.it.dao.UserDao;
import by.it.model.User;
import org.h2.tools.Server;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;


public class Runner {

    // private final Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    private final static Server SERVER;

    static {
        try {
            SERVER = Server.createTcpServer().start();
        } catch (SQLException e) {
            throw new RuntimeException("error start server " + e);
        }
    }

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
        userDao.create(User.builder()
                .firstName("Денис")
                .lastName("Карпенко")
                .email("k.denis.vlad@gmail.com").build());

        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user.getId() + " " + user.getFirstName() + " " + user.getLastName() + " " + user.getEmail());
        }

        User userIam = userDao.findByID(11);
        userIam.setFirstName(userIam.getFirstName().toUpperCase());
        userIam.setLastName(userIam.getLastName().toUpperCase());
        userIam.setEmail(userIam.getEmail().toUpperCase());
        userDao.update(userIam);


        User userFindById = userDao.findByID(11L);
        System.out.println(userFindById.getFirstName() + " " + userFindById.getLastName() + " " + userFindById.getEmail());

        userDao.deleteById(1L);

        userDao.findAll().forEach(System.out::println);

//        System.out.println(userIam.hashCode());
//        System.out.println(1607060782);

        userDao.create(User.builder()
                .firstName("Денис")
                .lastName("Карпенко")
                .email("k.denis.vlad@gmail.com").build());

        userDao.findAll().forEach(System.out::println);
    }



}

