package com.example.loginproject.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.loginproject.service.fileservice;

@RestController
@RequestMapping("/api/files")
public class filecontroller {

    private final fileservice fileService;

    public filecontroller(fileservice fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file) {

        try {

            if (file.isEmpty()) {
                return ResponseEntity.badRequest()
                        .body("Please select a file");
            }

            String fileKey = fileService.uploadFile(file);

            return ResponseEntity.ok(
                    "File uploaded successfully: " + fileKey
            );

        } catch (IOException e) {

            return ResponseEntity.internalServerError()
                    .body("File upload failed");
        }
    }
}