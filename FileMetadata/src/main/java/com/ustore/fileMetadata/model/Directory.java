package com.ustore.fileMetadata.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "D")
public class Directory extends Path {

	@OneToMany(fetch = FetchType.LAZY)
	private List<Path> paths;

	public List<Path> getPaths() {
		return paths;
	}

	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}

	@Override
	public String getType() {
		return "D";
	}
}
