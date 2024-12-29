package com.example.photo_clone.web;

import com.example.photo_clone.model.Photo;
import com.example.photo_clone.service.PhotoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class PhotoController {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, World";
    }

    @GetMapping("/photos")
    public ArrayList<Photo> get() {
        return photoService.getAllPhotos();
    }

    @GetMapping("/photo/{id}")
    public Photo photo(@PathVariable String id) {
        return photoService.getPhotoById(id);
    }

    @DeleteMapping("/photo/delete/{id}")
    public void deletePhoto(@PathVariable String id) {
        photoService.remove(id);
    }

    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = photoService.save(file.getOriginalFilename(),file.getContentType(), file.getBytes());
        return photo;
    }

}
