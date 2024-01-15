package com.spring.book.Controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.spring.book.helper.FileUploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.http.HttpResponse;
import java.util.Objects;

@RestController
public class FileUploaderControl {

    private FileUploadHelper fileUploadHelper;

    @Autowired
    public void setFileUploadHelper(FileUploadHelper fileUploadHelper) {
        this.fileUploadHelper = fileUploadHelper;
    }

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//        System.out.println(file.getContentType());
//        System.out.println(file.getName());


        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }

            if (!Objects.equals(file.getContentType(), "image/png")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only png files are allowed");
            }

            // File upload code....
            boolean flag = fileUploadHelper.uploadFile(file);
            if (flag) {
//                return ResponseEntity.ok("File Uploaded Successfully");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something Went wrong");
    }
}
