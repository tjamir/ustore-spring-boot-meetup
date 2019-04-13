package re.ustore.objectstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

@SpringBootApplication
public class ObjectstorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObjectstorageApplication.class, args);
    }


}
