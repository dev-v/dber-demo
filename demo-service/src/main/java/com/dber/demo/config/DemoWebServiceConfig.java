package com.dber.demo.config;

import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.dber.demo.resolver.FastJsonArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.method.annotation.RequestParamMapMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.AbstractView;

import java.util.ArrayList;
import java.util.List;

//@Configuration
public class DemoWebServiceConfig extends WebMvcConfigurerAdapter {


  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//    argumentResolvers.add(new FastJsonArgumentResolver());
  }

//  @Override
//  public void addCorsMappings(CorsRegistry registry) {
//    registry.addMapping("/**")
//            .allowedOrigins("http://localhost:8000",
//                    "http://localhost:8001",
//                    "http://localhost:8002",
//                    "http://127.0.0.1:8000",
//                    "http://127.0.0.1:8001",
//                    "http://127.0.0.1:8002")
//            .allowCredentials(true)
//            .allowedHeaders("*")
//            .exposedHeaders(HttpHeaders.SET_COOKIE)
//            .maxAge(1800);
//  }

  @Override
  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(fastJsonHttpMessageConverter());
  }

  @Bean
  public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();

    FastJsonConfig config = converter.getFastJsonConfig();
    config.setSerializerFeatures(SerializerFeature.BrowserSecure,
            SerializerFeature.WriteDateUseDateFormat, SerializerFeature.PrettyFormat);
//        config.setDateFormat(JSON.DEFFAULT_DATE_FORMAT);
    config.setParserConfig(ParserConfig.global);

    List<MediaType> supportedMediaTypes = new ArrayList<>();
    supportedMediaTypes.add(MediaType.APPLICATION_JSON);
    supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
    supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
    supportedMediaTypes.add(MediaType.TEXT_PLAIN);
//        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
//        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
//        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
//        supportedMediaTypes.add(MediaType.APPLICATION_XML);
//        supportedMediaTypes.add(MediaType.IMAGE_GIF);
//        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
//        supportedMediaTypes.add(MediaType.IMAGE_PNG);
//        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
//        supportedMediaTypes.add(MediaType.TEXT_HTML);
//        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
//        supportedMediaTypes.add(MediaType.TEXT_XML);
    converter.setSupportedMediaTypes(supportedMediaTypes);
    return converter;
  }

  @Bean
  public CharacterEncodingFilter characterEncodingFilter() {
    CharacterEncodingFilter filter = new CharacterEncodingFilter();
    filter.setEncoding("utf-8");
    filter.setForceEncoding(true);
    return filter;
  }

  @Bean
  public AbstractView jsonView() {
    return new FastJsonJsonView();
  }

  @Bean
  public RequestParamMapMethodArgumentResolver requestParamMapMethodArgumentResolver() {
    return new RequestParamMapMethodArgumentResolver();
  }
}
