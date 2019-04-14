package re.ustore.objectstorage.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Component;
import re.ustore.objectstorage.model.ContentFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileContentDao {

    private GridFsTemplate gridFsTemplate;

    public void save(ContentFile contentFile){
        InputStream inputStream = new ByteArrayInputStream(contentFile.getBytes());
        DBObject metaData = new BasicDBObject();
        metaData.put("id", contentFile.getId());
        metaData.put("user", contentFile.getUser());
        gridFsTemplate.store(inputStream,metaData).toString();
    }


    public ContentFile find(Long id){

        try {
            List<GridFSFile> gridFSFiles = new ArrayList<GridFSFile>();
            GridFSFile gridFSFile = gridFsTemplate.findOne(new Query(Criteria.where("metadata.id").is(id.toString())));
            ContentFile contentFile = new ContentFile();
            contentFile.setId(id);
            contentFile.setUser(gridFSFile.getMetadata().get("user").toString());
            byte[] bytes = this.gridFsTemplate.getResource(gridFSFile).getInputStream().readAllBytes();
            contentFile.setBytes(bytes);
            return contentFile;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public Boolean delete(Long id){

        try {
            List<GridFSFile> gridFSFiles = new ArrayList<GridFSFile>();
            gridFsTemplate.delete(new Query(Criteria.where("metadata.id").is(id.toString())));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
