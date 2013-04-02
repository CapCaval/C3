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
package c3;

import org.capcaval.c3.application.Application;
import org.capcaval.c3.application.annotations.AppInformation;
import org.capcaval.c3.application.annotations.AppProperty;


@AppInformation (version="1.0", about = "This a Hello world application with C³")
public class HelloWorldApplication extends Application {
	@AppProperty(comment="Application which salute anyone.")
	String name = "World";
	
	public static void main(String[] args) {
		HelloWorldApplication app = new HelloWorldApplication();
		app.launchApplication(args);
	}
	
	@Override
	public void notifyApplicationToBeRun(String applicationDescrition, String componentsDescription) {
		System.out.println("Application started");
		
		// use your component
		System.out.println("Hello " + this.name + "!");
	}

	@Override
	public void notifyApplicationToBeClosed() {
		System.out.println("bye bye, application closed");
	}
}
