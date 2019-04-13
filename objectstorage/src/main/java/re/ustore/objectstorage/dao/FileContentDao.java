package re.ustore.objectstorage.dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSFile;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import re.ustore.objectstorage.model.ContentFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
//        List<GridFSFile> gridFSFiles = new ArrayList<GridFSFile>();
//        gridFsTemplate.find(new Query(Criteria.where("metadata.id").is(id.toString()))).into(gridFSFiles);
//
//        GridFSFile gridFSFile = gridFSFiles.stream().findFirst().get();
//
//        ContentFile contentFile = new ContentFile();
//        contentFile.setId(id);
//        contentFile.setUser(gridFSFile.getMetaData().get("user").toString());
//        contentFile.setBytes(gridFSFile.);

        return null;
    }


}
