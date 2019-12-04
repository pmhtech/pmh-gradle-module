package net.pmhtech.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;


@Configuration
@EnableWebMvc
public class WebConfig  implements WebMvcConfigurer {

	@Autowired
	private JwtInterceptor jwtInterceptor;

	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowedMethods("*")
				.allowedOrigins("*")
				.allowCredentials(true)
			//	.exposedHeaders(JwtCrypt.JWT_TOKEN_HEADER)
				.maxAge(3600);
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(jwtInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/users/guest")

				// Id 중복검사
				.excludePathPatterns("/users/duplicate")
				.excludePathPatterns("/auth/phone")
				.excludePathPatterns("/ping")
				.excludePathPatterns("/token")
				.excludePathPatterns("/token/refresh")
				.excludePathPatterns("/error")


				// Swagger Exclude
				.excludePathPatterns("/resources/**")
				.excludePathPatterns("/swagger-resources/**")
				.excludePathPatterns("/configuration/ui")
				.excludePathPatterns("/configuration/security")
				.excludePathPatterns("/swagger/**")
				.excludePathPatterns("/swagger-ui.html")
				.excludePathPatterns("/v2/api-docs")
				.excludePathPatterns("/webjars/**");


	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("**/**")
				.addResourceLocations("/WEB-INF/resources/");

		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}