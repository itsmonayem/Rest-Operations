package com.spring.book.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileUploadHelper {
    public final String UPLOAD_DIR="/home/dsi/Documents/Spring Boot Project/book/src/main/resources/static/image";
    public boolean uploadFile(MultipartFile multipartFile) {
        boolean flag = false;

        try {
//            InputStream inputStream = file.getInputStream();
//            byte data[] = new byte[inputStream.available()];
//            inputStream.read();
//
//            //write
//            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR+ File.separator+file.getOriginalFilename());
//            fileOutputStream.write(data);
//
//            fileOutputStream.flush();
//            fileOutputStream.close();


//            One line upload
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);


            flag=true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return flag;
    }
}
