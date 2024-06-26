package com.tools.images.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tools.images.models.File;

public interface IImagesRepository extends JpaRepository<File, Long>{
    
}
