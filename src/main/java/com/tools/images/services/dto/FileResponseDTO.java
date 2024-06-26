package com.tools.images.services.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FileResponseDTO {

    private byte[] content;
    private String name;
    private Long size;
    private LocalDateTime uploadDate;
    
}
