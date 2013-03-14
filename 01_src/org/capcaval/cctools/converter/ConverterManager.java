package org.capcaval.cctools.converter;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import org.capcaval.cctools.converter.basicconverters.DoubleToString;
import org.capcaval.cctools.converter.basicconverters.IntegerToString;
import org.capcaval.cctools.converter.basicconverters.StringToDouble;
import org.capcaval.cctools.converter.basicconverters.StringToInteger;

public class ConverterManager {

	static protected Map<Class<?>, Map<Class<?>, Converter<?,?>>> map = new IdentityHashMap<>();
	
	public ConverterManager(){
		this.addConverter(new StringToInteger());
		this.addConverter(new StringToDouble());
		this.addConverter(new IntegerToString());
		this.addConverter(new DoubleToString());
	}
	
	public void addConverter( Converter<?,?> converter){
		Map<Class<?>, Converter<?,?>> m = map.get(converter.getInputType());
		
		// allocate a new one if none
		if(m==null){
			// allocate a new HashMap
			m = new IdentityHashMap<Class<?>, Converter<?,?>>();
			//add it
			map.put(converter.getInputType(), m);
		}
		// add the out type
		m.put(converter.getOutputType(), converter);
	}

	public <I,O> Converter<I,O> getConverter(Class<I> fromType, Class<O> outType){
		Converter<I,O> converter = null;
		
		Map<Class<?>, Converter<?,?>> m = map.get(fromType);
		// find the inType try to find the out one, if none return null
		if(m != null){
			converter = (Converter<I,O>)m.get(outType);
		}
		
		return converter;
	}
}
