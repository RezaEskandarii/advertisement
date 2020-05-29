package com.tutorialpro.tutorialpro.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadService {

    /**
     * upload file to given destination .
     * @param multipartFile
     * @param path
     */
    public void upload(MultipartFile multipartFile, String path) {
        try {
            // get multipartFile's bytes
            byte[] bytes = multipartFile.getBytes();
            Path p = Paths.get(path);
            Files.write(p, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
