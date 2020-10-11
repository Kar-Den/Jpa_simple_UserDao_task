package by.it.dao;

import java.util.List;

public interface Crud {

    Object findByID(long id);

    List<Object> findAll();

    Object create(Object o);

    Object update(Object o);

    void deleteById();

}
