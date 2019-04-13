package com.ustore.fileMetadata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustore.fileMetadata.model.Path;
import com.ustore.fileMetadata.repository.PathRepository;

@Service
public class MetadataService {
	
	@Autowired
	PathRepository pathRepository;
	
	public List<Path> getAllPathsByUser(Long userId) {
		return pathRepository.findByUserId(userId);
	}
	
	public void createPath() {
		
	}

}
