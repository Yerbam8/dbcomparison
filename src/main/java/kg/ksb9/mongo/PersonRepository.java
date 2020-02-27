package kg.ksb9.mongo;

import kg.ksb9.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, Integer> {
}
