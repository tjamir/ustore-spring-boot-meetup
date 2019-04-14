package com.ustore.fileMetadata.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustore.fileMetadata.model.File;
import com.ustore.fileMetadata.model.Path;

@Repository
public interface PathRepository extends JpaRepository<Path, Long>{

	List<File> findByUserId(Long userId);
}
