package kg.ksb9.mongo;

import com.opencsv.CSVReader;
import kg.ksb9.Person;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
@Aspect
@Profile("mongo")
public class CsvReaderMongo {
    private PersonRepository personRepository;

    @Autowired
    public CsvReaderMongo(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    public boolean csvRead(String csvFile) {


        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                personRepository.save(new Person(Integer.parseInt(line[0]), line[1], line[2], line[3]));

            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Mongo");
        return true;
    }
}
