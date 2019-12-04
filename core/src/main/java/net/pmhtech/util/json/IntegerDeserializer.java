package net.pmhtech.util.json;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class IntegerDeserializer extends TypeAdapter<Integer> {

	
	@Override
	public Integer read(JsonReader jsonReader) throws IOException {
		if (jsonReader.peek() == JsonToken.NULL) {
	        jsonReader.nextNull();
	        return null;
	    }

	    try {
	        String value = jsonReader.nextString();
	        if ("".equals(value)) {
	            return null;
	        }else{
	        	int idx = value.indexOf(".");
	        	if(idx!=-1){
	        		value=value.substring(0,idx);
				}


			}
	        return Integer.parseInt(value);
	    } catch (NumberFormatException e) {
	        throw new JsonSyntaxException(e);
	    }
	}
	
	
	@Override
	public void write(JsonWriter jsonWriter, Integer value) throws IOException {

		 if (value == null) {
		        jsonWriter.nullValue();
		        return;
	    }
	    jsonWriter.value(value);
		
	}

	

	

}
