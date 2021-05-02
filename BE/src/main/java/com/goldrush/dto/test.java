package com.goldrush.dto;

import java.io.File;

public class test {
	private File file;
	private String text;
	@Override
	public String toString() {
		return "test [file=" + file + ", text=" + text + "]";
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
