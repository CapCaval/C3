package org.capcaval.ccoutils.data;

import java.util.ArrayList;

import org.capcaval.ccoutils.converter.Converter;
import org.capcaval.ccoutils.converter.basicconverters.DoubleToString;
import org.capcaval.ccoutils.converter.basicconverters.EnumToString;
import org.capcaval.ccoutils.converter.basicconverters.FloatToString;
import org.capcaval.ccoutils.converter.basicconverters.IntegerToString;
import org.capcaval.ccoutils.converter.basicconverters.LongToString;
import org.capcaval.ccoutils.converter.basicconverters.StringToDouble;
import org.capcaval.ccoutils.converter.basicconverters.StringToEnum;
import org.capcaval.ccoutils.converter.basicconverters.StringToFloat;
import org.capcaval.ccoutils.converter.basicconverters.StringToInteger;
import org.capcaval.ccoutils.converter.basicconverters.StringToLong;
import org.capcaval.ccoutils.converter.basicconverters.StringToString;
import org.capcaval.ccoutils.data.Data.DataFactory;
import org.capcaval.ccoutils.data._impl.DataImpl;

public class DataFactoryImpl implements DataFactory {

	private ArrayList<Converter<?,?>> converterList;

	DataFactoryImpl(){
		// allocate some default converter
		this.converterList = new ArrayList<Converter<?,?>>();
		this.converterList.add(new DoubleToString());
		this.converterList.add(new EnumToString());
		this.converterList.add(new FloatToString());
		this.converterList.add(new IntegerToString());
		this.converterList.add(new LongToString());
		this.converterList.add(new StringToDouble());
		this.converterList.add(new StringToEnum());
		this.converterList.add(new StringToFloat());
		this.converterList.add(new StringToInteger());
		this.converterList.add(new StringToLong());
		this.converterList.add(new StringToString());
	}
	
	@Override
	public <T> Data<T> newData() {
		Data<T> dataInstance = new DataImpl<T>();
		// fill the default transformer
		for(Converter<?,?> converter : this.converterList){
			if(converter.getOutputType() == dataInstance.getValue().getClass()){
				dataInstance.addDataConverter((Converter<?,T>)converter);}
		}
		
		return dataInstance;
	}

	@Override
	public <T> Data<T> newData(T data) {
		Data<T> dataInstance = new DataImpl<T>(data);
		// fill the default transformer
		for(Converter<?,?> converter : this.converterList){
			if(converter.getInputType() == data.getClass()){
				dataInstance.addDataConverter((Converter<?,T>)converter);}
		}
		return dataInstance;
	}

	@Override
	public <T> DataReadOnly<T> newReadOnlyData(T data) {
		return new DataImpl<T>(data);
	}

	
	
}
