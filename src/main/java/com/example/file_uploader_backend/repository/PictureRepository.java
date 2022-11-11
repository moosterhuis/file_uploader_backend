package com.example.file_uploader_backend.repository;

import com.example.file_uploader_backend.domain.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
