package com.ustore.fileMetadata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustore.fileMetadata.model.File;
import com.ustore.fileMetadata.model.payload.PathDTO;
import com.ustore.fileMetadata.repository.PathRepository;
import com.ustore.fileMetadata.util.MappingUtil;

@Service
public class MetadataService {
	
	@Autowired
	PathRepository pathRepository;
	
	MappingUtil mapper;
	
	public List<File> getAllFilesByUser(Long userId) {
		return pathRepository.findByUserId(userId);
	}
	
	public void createOrUpdatePath(PathDTO pathDTO) {
		
		pathRepository.save(mapper.mapPathRequestToFilePath(pathDTO));
	}

}
