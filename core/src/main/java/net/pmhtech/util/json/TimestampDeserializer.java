package net.pmhtech.util.json;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.sql.Timestamp;

public class TimestampDeserializer extends TypeAdapter<Timestamp> {
    @Override
    public void write(JsonWriter out, Timestamp value) throws IOException {
        if (value == null)
            out.nullValue();
        else
            out.value(value.getTime());
    }

    @Override
    public Timestamp read(JsonReader in) throws IOException {
    	
    	String str = in.nextString(); 
    	
    	
    	if (in != null && !"".equals(str))
            return new Timestamp(Long.parseLong(str));
        else
            return null;
    }
}