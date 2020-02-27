package kg.ksb9.jdbc;

import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;

@Component
public class CsvReaderJdbc {
    private PersonDao personDao;

    @Autowired
    public CsvReaderJdbc(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean csvRead(String csvFile) {


        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                personDao.savePerson(Integer.parseInt(line[0]), line[1], line[2], line[3]);

            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Jdbc");
        return true;
    }
}
