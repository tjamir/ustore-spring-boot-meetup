package com.ustore.fileMetadata.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustore.fileMetadata.model.Directory;
import com.ustore.fileMetadata.model.File;
import com.ustore.fileMetadata.model.Path;
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

	public void deletePath(Long id) {
		Path path = pathRepository.getOne(id);

		if (path.getType().equalsIgnoreCase("F")) {
			pathRepository.delete(path);
		} else if (path.getType().equalsIgnoreCase("D")) {
			Directory directory = (Directory) path;

			if (Objects.nonNull(directory.getPaths()) && !directory.getPaths().isEmpty()) {
				for (Path pat : directory.getPaths()) {
					deletePath(pat.getId());
				}
			} else {
				pathRepository.delete(directory);
			}
		}

	}

}
