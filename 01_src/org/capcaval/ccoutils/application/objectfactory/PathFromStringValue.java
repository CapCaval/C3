/*
Copyright (C) 2012 by CapCaval.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
*/
package org.capcaval.ccoutils.application.objectfactory;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathFromStringValue implements ObjectFactoryFromStringValue <Path>{

	@Override
	public Path newObjectFromStringValue(String stringValue,
			StringBuffer errorMessage) {
		Path p = FileSystems.getDefault().getPath( stringValue);
		if(Files.exists(p) == false){
			errorMessage.append("the following Property Path does not exist : " + p.toAbsolutePath());
		}
		return p;
	}

	@Override
	public String newStringFromObjectValue(Path object,
			StringBuffer errorMessage) {
		return object.toString();
	}

}
