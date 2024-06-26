package com.tools.images.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tools.images.models.File;
import com.tools.images.services.dto.FileResponseDTO;
import com.tools.images.services.interfaces.IJpgToPngConverter;
import com.tools.images.services.mapper.IFileMapper;


@RestController
@RequestMapping("/api/images")
@CrossOrigin("*")
public class ImageController {

    @Autowired
    private IJpgToPngConverter jpgToPngConverter;

    @Autowired
    private IFileMapper fileMapper;


    @PostMapping("/jpg-to-png")
    public ResponseEntity<FileResponseDTO> convertJpgToPng(@RequestParam("file") MultipartFile file){
        File pngFile = jpgToPngConverter.convert(file);
        return ResponseEntity.ok( fileMapper.toDTO(pngFile));
    }
    
}
