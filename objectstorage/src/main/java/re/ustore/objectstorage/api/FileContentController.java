package re.ustore.objectstorage.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import re.ustore.objectstorage.dao.FileContentDao;
import re.ustore.objectstorage.model.ContentFile;


@RestController
public class FileContentController {

	@Autowired
	private FileContentDao fileDao;

	@GetMapping("/")
	String index(){
		return "INDEX";
	}

	@GetMapping(value = "/{id}")
	Object get(@PathVariable long id) {
		ContentFile contentFile = fileDao.find(id);
		if(contentFile != null){
			return contentFile;
		}else{
			return "File Not Found";
		}

    }
    @PostMapping(value = "/")
	String save(@RequestParam("id") Long id, @RequestParam("user")String user,
						 @RequestParam("file") MultipartFile file) throws Exception {

		ContentFile contentFile = new ContentFile();
		contentFile.setId(id);
		contentFile.setFilename(file.getOriginalFilename());
		contentFile.setUser(user);
		contentFile.setBytes(file.getBytes());
		fileDao.save(contentFile);
	    return "Data uploaded successfully !!";
	}

	@DeleteMapping(value = "/{id}")
	String delete(@PathVariable long id) {
		if (fileDao.delete(id)){
			return "Data deleted successfully !!";
		}else{
			return "500";
		}


	}



}
