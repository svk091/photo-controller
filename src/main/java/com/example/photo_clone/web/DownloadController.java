package com.example.photo_clone.web;


import com.example.photo_clone.model.Photo;
import com.example.photo_clone.service.PhotoService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DownloadController {

    private final PhotoService photoService;

    public DownloadController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable String id) {
        Photo photo = photoService.getPhotoById(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        byte[] data = photo.getData();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.valueOf(photo.getContentType()));
        ContentDisposition build = ContentDisposition.builder("attachment").filename(photo.getFileName()).build();
        httpHeaders.setContentDisposition(build);
        return new ResponseEntity<>(data, httpHeaders, HttpStatus.OK);
    }
}
