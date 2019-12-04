package net.pmhtech.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value="/ping")
public class PingEndpoint {
	@RequestMapping(value ="" ,method=RequestMethod.GET)
	public Map<String,String> heartBeat() {
		
		Map<String,String> result = new HashMap<String,String>(); 
		
		result.put("success", "true");
		
		return result;
		
		
	}
	
}
