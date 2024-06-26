package com.tools.images.services.mapper;

import org.mapstruct.Mapper;

import com.tools.images.models.File;
import com.tools.images.services.dto.FileResponseDTO;

@Mapper
public interface IFileMapper {
    FileResponseDTO toDTO(File file);
}
