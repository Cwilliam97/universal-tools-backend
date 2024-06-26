package com.tools.images.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tools.images.services.mapper.IFileMapper;

@Configuration
public class MapImagesConfig {
    @Bean
    IFileMapper mapStructMapperIFileMapper(){
        return Mappers.getMapper(IFileMapper.class);
    }
}
