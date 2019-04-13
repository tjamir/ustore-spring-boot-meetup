package com.ustore.fileMetadata.model.payload;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javassist.bytecode.ByteArray;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PathDTO {

	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private Long size;
	
	@NotNull
	private Long userId;
	
	private byte[] content;
	
	@NotNull
	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
