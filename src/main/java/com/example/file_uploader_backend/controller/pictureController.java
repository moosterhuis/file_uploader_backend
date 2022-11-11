package com.example.file_uploader_backend.controller;

import com.example.file_uploader_backend.domain.Picture;
import com.example.file_uploader_backend.service.PictureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:4200/")
public class pictureController {

    private final PictureService pictureService;

    public pictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping
    ResponseEntity<List<Picture>> getAllPictures() {
        List<Picture> pictures = pictureService.getAllPictures();
        return ResponseEntity.ok(pictures);
    }

    @PostMapping
    ResponseEntity<Picture> addPicture(@RequestParam(name = "file", required = false) MultipartFile file) throws IOException {
        Picture savedPicture = pictureService.addPicture(file);
        return ResponseEntity.ok(savedPicture);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deletePicture(@PathVariable Long id) {
        pictureService.deletePicture(id);
        return ResponseEntity.ok("Picture with id: '" + id + "' deleted");
    }
}
