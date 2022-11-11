package com.example.file_uploader_backend.service;

import com.example.file_uploader_backend.domain.Picture;
import com.example.file_uploader_backend.repository.PictureRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class PictureService {

    private final PictureRepository pictureRepository;

    public PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public List<Picture> getAllPictures() {
        return pictureRepository.findAll();
    }

    public Picture addPicture(MultipartFile file) throws IOException {
        Picture picture = new Picture(
                UUID.randomUUID().toString(),
                file.getOriginalFilename(),
                file.getContentType(),
                file.getBytes());
        return pictureRepository.save(picture);
    }

    public void deletePicture(Long id) {
        pictureRepository.deleteById(id);
    }
}
