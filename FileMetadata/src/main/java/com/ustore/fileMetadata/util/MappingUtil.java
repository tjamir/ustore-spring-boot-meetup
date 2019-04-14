package com.ustore.fileMetadata.util;

import org.apache.commons.codec.digest.DigestUtils;

import com.ustore.fileMetadata.model.Directory;
import com.ustore.fileMetadata.model.File;
import com.ustore.fileMetadata.model.Path;
import com.ustore.fileMetadata.model.payload.PathDTO;

public class MappingUtil {
	
	public Path mapPathRequestToFilePath(PathDTO pathDTO) {
		
		if(pathDTO.getType().equalsIgnoreCase("f")) {
			File file = new File();
			file.setHash(DigestUtils.md5Hex(pathDTO.getContent()));
			file.setUserId(pathDTO.getUserId());
			file.setName(pathDTO.getName());
			file.setSize(pathDTO.getSize());
			return file;
		} else if(pathDTO.getType().equalsIgnoreCase("d")) {
			Directory directory = new Directory();
			directory.setUserId(pathDTO.getUserId());
			directory.setName(pathDTO.getName());
			directory.setSize(pathDTO.getSize());
			
			return directory;
		}
		return null;
	}

}
