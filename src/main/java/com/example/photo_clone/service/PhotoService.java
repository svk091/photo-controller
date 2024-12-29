package com.example.photo_clone.service;

import com.example.photo_clone.model.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Iterator;

@Service
public class PhotoService {
    private ArrayList<Photo> photos;

    public PhotoService() {
        this.photos = new ArrayList<>();
    }

    public ArrayList<Photo> getAllPhotos() {
        return photos;
    }

    public Photo getPhotoById(String id) {
        for (Photo photo : this.photos) {
            if (photo.getId().equals(id)) {
                return photo;
            }
        }
        return null;
    }

    public Photo save(String fileName,String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setFileName(fileName);
        photo.setData(data);
        photo.setContentType(contentType);
        this.photos.add(photo);
        return photo;
    }

    public void remove(String id) {
        Iterator<Photo> iterator = this.photos.iterator();
        while (iterator.hasNext()) {
            Photo photo = iterator.next();
            if (photo.getId().equals(id)) {
                iterator.remove();
                return;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
