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
package org.capcaval.c3.sample.tutorial02;

import org.capcaval.c3.c3application.C3Application;
import org.capcaval.c3.component.annotation.ConsumedEvent;
import org.capcaval.c3.component.annotation.UsedService;
import org.capcaval.c3.sample.tutorial01.hellomachine.HelloMachineServices;
import org.capcaval.c3.sample.tutorial01.hellomachine._impl.HelloMachineImpl;
import org.capcaval.c3.sample.tutorial02.hellomachine._impl.HelloMachineEvent;

public class HelloMachineMain extends C3Application{

	@UsedService
	HelloMachineServices hms;
	
	public static void main(String[] args) {
		HelloMachineMain app = new HelloMachineMain();
		app.launchApplication(args, HelloMachineImpl.class);
		
	}

	@Override
	public void notifyApplicationToBeRun(String applicationDescrition,
			String componentsDescription) {
		System.out.println(componentsDescription);
		
		// use the service to retrieve a salute sentence
		String sentence = hms.salute("world");
		// display the sentence to the system output 
		System.out.println(sentence);

	}

	@Override
	public void notifyApplicationToBeClosed() {
	}

	@ConsumedEvent
	HelloMachineEvent createHelloEvent(){
		HelloMachineEvent event = new HelloMachineEvent() {
			@Override
			public void notifyHello(String helloSentence) {
				System.out.println(helloSentence);
			}
		};
		return event;
	}
}
