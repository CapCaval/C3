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
package org.capcaval.lafabrique.file._test;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.net.URL;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.capcaval.lafabrique.file.TokenTool;
import org.capcaval.lafabrique.lang.ArrayTools;
import org.capcaval.lafabrique.lang.StringTools;



public class TokenToolTest {


	@org.junit.Test
	public void testReplaceStringFromReader() throws IOException {
		String sourceStr = "Hello how are you Mr {NAME}, I do hope that {everything }is going ok for you.\n Bye Mr {NAME}.";
		Reader source = new StringReader(sourceStr);
				
		Map<String, String> map = ArrayTools.newMap("NAME", "Joe", "SURNAME", "Smith");
		
		Writer output = TokenTool.replaceTokenFromReader(source, map, '{', '}');
		
		System.out.println("#testReplaceStringFromReader :\n" + output);
		
		Assert.assertEquals("Hello how are you Mr Joe, I do hope that {everything }is going ok for you.\n Bye Mr Joe.", 
				output.toString());
	}

	@org.junit.Test
	public void testReplaceStringFromReaderInUT8() throws IOException {
		String sourceStr = "éî. Hello how are you Mr {NAME}, I do hope that {everything }is going ok for you.\n Bye Mr {NAME}.";
		Reader source = new StringReader(sourceStr);
				
		Map<String, String> map = ArrayTools.newMap("NAME", "Joe", "SURNAME", "Smith");
		
		Writer output = TokenTool.replaceTokenFromReader(source, map, '{', '}');
		
		System.out.println("#testReplaceStringFromReader :\n" + output);
		
		Assert.assertEquals("éî. Hello how are you Mr Joe, I do hope that {everything }is going ok for you.\n Bye Mr Joe.", 
				output.toString());
	}

	
	@org.junit.Test
	public void testGetAllTokenFromReader() throws IOException {
		String sourceStr = "Hello how are you Mr {NAME}, I do hope that {everything }is going ok for you.\n Bye Mr {NAME}.";
		Reader source = new StringReader(sourceStr);
				
		List<String> list = ArrayTools.newArrayList("NAME");
		
		List<String> output = TokenTool.getAllTokenFromReader(source, '{', '}', 32);
		
		System.out.println("#testGetAllTokenFromReader : \n" + output);
		
		Assert.assertEquals(list, output);
	}

	@org.junit.Test
	public void testMultiLine() throws IOException {
				
		String sourceStr = StringTools.multiLineString(
				"This is the header",
				"",
				"	Name :  Jack",
				"	Age : 36",
				"",
				"	Name :  Joe",
				"	Age : 10",
				"",
				"this is the footer",				
				"",
				"Z1 joe 12 bob 24");
		
		
		URL fileUrl = this.getClass().getResource("TestMultiLines.txt");

		Reader source = new StringReader(sourceStr);
				
		List<Map<String, String>> list = ArrayTools.newArrayList(
				ArrayTools.newMap("NAME", "Joe", "AGE", "10"),
				ArrayTools.newMap("NAME", "Jack", "AGE", "36"));
		
		
		String output = TokenTool.replaceBlocksInsideFile(
				fileUrl.getFile().toString(), 
				list, 
				"#Z1 start#","#Z1 end#",
				'{', '}');
		
		System.out.println("#testGetAllTokenFromReader : \n" + output);
		
		System.out.println(sourceStr);
		
		Assert.assertEquals(sourceStr, output);
	}
	

}
