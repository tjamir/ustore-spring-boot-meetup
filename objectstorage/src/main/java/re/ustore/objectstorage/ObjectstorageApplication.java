package re.ustore.objectstorage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import re.ustore.objectstorage.api.FileContentController;
import re.ustore.objectstorage.dao.FileContentDao;

@SpringBootApplication
public class ObjectstorageApplication {

    public static void main(String[] args) {
        SpringApplication.run(ObjectstorageApplication.class, args);
    }


}
