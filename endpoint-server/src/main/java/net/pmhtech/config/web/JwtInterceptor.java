package net.pmhtech.config.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor{

	//@Autowired
	//private JwtCrypt jwtCrypt;


	private String getClientIpAddr(HttpServletRequest request){




		String ip = request.getHeader("X-Forwarded-For");

		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}




	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {


		String reqMethod = request.getMethod();
		String url = request.getRequestURI();
		if("OPTIONS".equals(reqMethod)){
			return true;
		}



		if("POST".equals(reqMethod) && "/users".equals(url) ) {
			return true;
		}
		String ip = this.getClientIpAddr(request);


		/*log.info("=================================================");
		log.info(" Access IP Address  :       "+ip);
		log.info("=================================================");
		
		if(thingServerHost.equals(ip) || thingQuartzHost.equals(ip)){
			AccessUser accessUser = new AccessUser();
			accessUser.setUserId("System");
			accessUser.setIp(ip);
			accessUser.setLocaleCode("KOR");
			request.setAttribute("accessUser", accessUser);
			return true;
		}

		String accessToken =request.getHeader(JwtCrypt.JWT_TOKEN_HEADER);

		if(accessToken==null) {
			throw new JwtNotFoundException();
		}

        int idx = accessToken.indexOf("Bearer ");
		if(idx!=0){
            throw new JwtVerifyException();
        }
        accessToken= accessToken.replace("Bearer ","");

        JwtUser jwtUser = jwtCrypt.getAvailToken(accessToken);
		AccessUser accessUser = new AccessUser();
		Integer userIdx = jwtUser.getUserIdx();
		String userId = jwtUser.getUserId();
		accessUser.setUserId(userId);
		accessUser.setUserIdx(userIdx);
		accessUser.setIp(ip);
		accessUser.setLocaleCode("KOR");
		
		
		
		request.setAttribute("accessUser", accessUser);*/
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
