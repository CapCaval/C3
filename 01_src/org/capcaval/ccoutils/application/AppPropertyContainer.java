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
package org.capcaval.ccoutils.application;

import java.util.ArrayList;
import java.util.List;

public class AppPropertyContainer {
	protected List<AppPropertyInfo> allAppPropertyInfoList = new ArrayList<AppPropertyInfo>();
	protected List<AppPropertyInfo> allPersistentAppPropertyInfoList = new ArrayList<AppPropertyInfo>();
	
	public AppPropertyInfo[] getAllAppPropertyInfo(){
		return this.allAppPropertyInfoList.toArray(new AppPropertyInfo[0]);
	}
	
	public AppPropertyInfo[] getAllPersistentAppPropertyInfo(){
		return this.allPersistentAppPropertyInfoList.toArray(new AppPropertyInfo[0]);
	}
	
	public void add(AppPropertyInfo property){
		this.allAppPropertyInfoList.add(property);
		// add in persistent if is the case
		if(property.isPersistent){
			// add it inside the persistent list
			this.allPersistentAppPropertyInfoList.add(property);
		}
	}
}
