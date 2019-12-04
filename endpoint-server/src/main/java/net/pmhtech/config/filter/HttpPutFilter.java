package net.pmhtech.config.filter;

import org.springframework.boot.web.servlet.filter.OrderedHttpPutFormContentFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpPutFilter {

    @Bean
    public HttpFormContentFilter httpFormFilter(){


        return new HttpFormContentFilter();
    }




    @Bean
    public OrderedHttpPutFormContentFilter httpPutFormContentFilter(){
        return new OrderedHttpPutFormContentFilter();
    }
}
