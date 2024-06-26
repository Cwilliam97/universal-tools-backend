package com.tools.images.services.interfaces;

import org.springframework.web.multipart.MultipartFile;

import com.tools.images.models.File;

public interface IJpgToPngConverter {
    File convert(MultipartFile file);
}
