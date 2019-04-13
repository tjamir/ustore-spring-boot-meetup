package re.ustore.objectstorage.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Response;

import re.ustore.objectstorage.dao.FileContentDao;
import re.ustore.objectstorage.model.ContentFile;

@Path("/ContentFile")
public class FileContentResource {
	
	private FileContentDao fileDao = null;
	
	@GET
    @Produces("application/json")
    public ContentFile getContentFile(long id) {
        
		return fileDao.find(id);
       
    }
	
	@POST
	@Consumes({MediaType.MULTIPART_FORM_DATA})
	public Response uploadPdfFile(  @FormDataParam("file") InputStream fileInputStream,
	                                @FormDataParam("file") ContentFile contetnFile) throws Exception
	{
	    String UPLOAD_PATH = "c:/temp/";
	    try
	    {
	        int read = 0;
	        byte[] bytes = new byte[1024];
	 
	        OutputStream out = new FileOutputStream(new File(UPLOAD_PATH + content ));
	        while ((read = fileInputStream.read(bytes)) != -1)
	        {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	    } catch (IOException e)
	    {
	        throw new WebApplicationException("Error while uploading file. Please try again !!");
	    }
	    return Response.ok("Data uploaded successfully !!").build();
	}
}
