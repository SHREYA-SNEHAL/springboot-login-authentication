package com.example.loginproject.service;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class fileservice {

    private final S3Client s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public fileservice(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    public String uploadFile(MultipartFile file) throws IOException {

        // Create a unique file name
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();

        // Create S3 upload request
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key("uploads/" + fileName)
                .contentType(file.getContentType())
                .build();

        // Upload file to S3
        s3Client.putObject(
                request,
                RequestBody.fromInputStream(
                        file.getInputStream(),
                        file.getSize()
                )
        );

        return "uploads/" + fileName;
    }
}