package kg.ksb9;

import kg.ksb9.aspects.InitDbAspect;
import kg.ksb9.aspects.TimeAspect;
import kg.ksb9.jdbc.CsvReaderJdbc;
import kg.ksb9.jdbc.PersonDao;
import kg.ksb9.mongo.CsvReaderMongo;
import kg.ksb9.mongo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Test {
    private PersonRepository personRepository;
    private PersonDao personDao;

    @Autowired
    public Test(PersonRepository personRepository, PersonDao personDao) {
        this.personRepository = personRepository;
        this.personDao = personDao;
    }

//    @EventListener(ApplicationReadyEvent.class)
    @TimeAspect
    public void initMongo() {
        CsvReaderMongo csvReaderMongo = new CsvReaderMongo(personRepository);
        csvReaderMongo.csvRead("C:\\dev\\goal\\ksb9\\src\\main\\resources\\MOCK_DATA.csv");
    }

    @EventListener(ApplicationReadyEvent.class)
    @TimeAspect
    @InitDbAspect
    public void initJdbc() {
        CsvReaderJdbc csvReaderJdbc = new CsvReaderJdbc(personDao);
        csvReaderJdbc.csvRead("C:\\dev\\goal\\ksb9\\src\\main\\resources\\MOCK_DATA.csv");
    }

}
