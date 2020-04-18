package com.navakha.basic.miscellaneous;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.navakha.basic.exceptions.EirException;

@SuppressWarnings("deprecation")
@Configuration
public class EirExceptionConfig extends WebMvcConfigurerAdapter {
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(EirException.class, new EirExceptionJackson2Serializer());
        objectMapper.registerModule(simpleModule);
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(objectMapper);
        converters.add(new ResourceHttpMessageConverter());
        converters.add(converter);
    }
}