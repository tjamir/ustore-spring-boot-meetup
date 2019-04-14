package re.ustore.objectstorage.api;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import re.ustore.objectstorage.dao.FileContentDao;
import re.ustore.objectstorage.model.ContentFile;


@RestController
@RequestMapping("/contentfile")
public class FileContentController {

	@Autowired
	private FileContentDao fileDao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ContentFile get(@PathVariable long id) {
		return fileDao.find(id);
       
    }

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Response save(@RequestParam("id") Long id, @RequestParam("user")String user,
						 @RequestParam("file") MultipartFile file) throws Exception {

		ContentFile contentFile = new ContentFile();
		contentFile.setId(id);
		contentFile.setUser(user);
		contentFile.setBytes(file.getBytes());
		fileDao.save(contentFile);
	    return Response.ok("Data uploaded successfully !!").build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Response delete(@PathVariable long id) {
		if (fileDao.delete(id)){
			return Response.ok("Data deleted successfully !!").build();
		}else{
			return Response.status(500).build();
		}


	}



}
