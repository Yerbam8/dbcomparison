package kg.ksb9.jdbc;

import kg.ksb9.Person;

import java.util.List;

public interface PersonDao {
    void savePerson(Integer id, String firstName, String lastName, String email);

    List<Person> getAllPersons();

    void updatePerson(Person person);

    void deletePerson(Integer id);
}
