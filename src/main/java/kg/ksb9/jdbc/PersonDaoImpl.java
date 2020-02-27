package kg.ksb9.jdbc;

import kg.ksb9.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void savePerson(Integer id, String firstName, String lastName, String email) {
        Person person = new Person(id, firstName, lastName, email);
        String sql = "INSERT INTO persons VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, person.getId(), person.getFirstName(), person.getLastName(), person.getEmail());
    }

    @Override
    public List<Person> getAllPersons() {
        return null;
    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(Integer id) {

    }
}
