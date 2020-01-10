package com.tutorialpro.tutorialpro.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadService {

    public void upload(MultipartFile multipartFile, String path) {
        try {
            byte[] bytes = multipartFile.getBytes();
            Path p = Paths.get(path);
            Files.write(p, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
