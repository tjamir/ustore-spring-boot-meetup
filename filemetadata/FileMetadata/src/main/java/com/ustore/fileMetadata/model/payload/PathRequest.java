package com.ustore.fileMetadata.model.payload;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import javassist.bytecode.ByteArray;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PathRequest {

	private Long id;
	
	@NotNull
	private Long size;
	
	@NotNull
	private Long userId;
	
	@NotNull
	private byte[] content;

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

}
