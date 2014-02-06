package org.capcaval.ccoutils.file._test;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.capcaval.ccoutils.file.DirectorySeeker;
import org.capcaval.ccoutils.file.FileSeekerResult;
import org.junit.Assert;
import org.junit.Test;

public class DirectorySeekerTest {

	@Test
	public void DirSeekerTest() {
		FileSeekerResult result = DirectorySeeker.seekDirectory("1_sr", ".");
		Assert.assertArrayEquals(new Path[]{Paths.get("./01_src")}, result.getPathList());
		
	}

}
