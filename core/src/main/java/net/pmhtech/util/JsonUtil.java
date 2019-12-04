package net.pmhtech.util;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import net.pmhtech.util.json.IntegerDeserializer;
import net.pmhtech.util.json.LongDeserializer;
import net.pmhtech.util.json.TimestampDeserializer;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class JsonUtil {
	
	
	
	
	private static final Gson GSON = new GsonBuilder().registerTypeAdapter(Timestamp.class, new TimestampDeserializer())
														.registerTypeAdapter(Long.class, new LongDeserializer())
													  	.registerTypeAdapter(Integer.class, new IntegerDeserializer()).create();

	public static <T> T toPojo(String jsonStr, Class<T> type) {
	
		return GSON.fromJson(jsonStr, type);
		
	}

	public boolean isJsonStr(String jsonStr) {
		
		try {
			GSON.fromJson(jsonStr, Object.class);
			return true;
		}catch(JsonSyntaxException ex) {
			return false;	
		}
		
	}
	
	public static String toJson(Object src) {
		
		return GSON.toJson(src);
		
	}
	
	public static String[] getNullValueFields(Object source) {
		
		final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<String>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }
	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}
	





	

	
	
	/*
	public static List<Map<String,?>> convertJsonToList(String jsonString) throws Exception{
		List<Map<String,?>> result = new ObjectMapper().readValue(jsonString, new TypeReference<ArrayList<HashMap<String,String>>>(){});
		return result;
	}*/
}