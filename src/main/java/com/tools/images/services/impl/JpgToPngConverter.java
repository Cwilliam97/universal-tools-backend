package com.tools.images.services.impl;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tools.images.models.File;
import com.tools.images.repository.IImagesRepository;
import com.tools.images.services.interfaces.IJpgToPngConverter;

@Service
public class JpgToPngConverter implements IJpgToPngConverter{
    @Autowired
    private IImagesRepository imagesRepository;

    @Override
    public File convert(MultipartFile file) {
        try{
            BufferedImage jpgImage = ImageIO.read(new ByteArrayInputStream(file.getBytes()));

            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            ImageIO.write(jpgImage, "png", pngOutputStream);
            byte[] pngData = pngOutputStream.toByteArray();

            File pngFile = File.builder()
                .name(file.getOriginalFilename().replace(".jpg", ".png"))
                .size((long) pngData.length)
                .uploadDate(LocalDateTime.now())
                .content(pngData)
                .build();
            
            imagesRepository.save(pngFile);

            return pngFile;               
        }catch(Exception e){
            throw new RuntimeException("Error converting JPG to PNG");
        }
    }
    
}
