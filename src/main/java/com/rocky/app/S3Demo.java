package com.rocky.app;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.nio.file.Path;

public class S3Demo {

    public static final String BUCKET_NAME = "anils-aws-s3-bucket"; // Replace with your bucket name

    public static void main(String[] args) {
        System.out.println("S3 Demo Application");

        // Initialize S3 Client
        S3Client s3Client = S3Client.builder()
                .region(Region.US_EAST_1) // Replace with your region
                .build();

        // Define the file path to upload (example: rocky.txt inside resources folder)
        Path filePath = Path.of("src/main/resources/rocky.txt"); // Adjust path if needed

        // Upload the file to S3
        s3Client.putObject(
                PutObjectRequest.builder()
                        .bucket(BUCKET_NAME)
                        .key("Rocky's Data") // The name for the file in S3
                        .build(),
                filePath
        );

        System.out.println("File uploaded successfully!");

        // Download the file from S3
        s3Client.getObject(GetObjectRequest.builder()
                .bucket(BUCKET_NAME)
                .key("ChatGPT Image May 21, 2025, 06_18_39 PM.png")
                .build(), Path.of("ChatGPT Image May 21, 2025, 06_18_39 PM.png"));

        System.out.println("File Downloaded successfully!");
    }
}
