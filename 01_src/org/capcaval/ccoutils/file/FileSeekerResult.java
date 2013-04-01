package org.capcaval.ccoutils.file;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileSeekerResult{
	private List<Path> fileList = new ArrayList<>();;

	public FileSeekerResult(){
	}
	
	void addFiles(Path... fileList){
		// add files
		for(Path p : fileList){
			this.fileList.add(p);
		}
	}
	
	public Path[] getFileList(){
		return this.fileList.toArray(new Path[0]);
	}

	public String[] getStringFileList(){
		List<String> stringList = new ArrayList<>();
		
		for(Path p : this.fileList){
			stringList.add(p.toString());
		}
		return stringList.toArray(new String[0]);
	}
}
