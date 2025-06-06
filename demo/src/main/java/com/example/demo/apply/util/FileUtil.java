package com.example.demo.apply.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class FileUtil {

    // 파일 저장 메서드
    public String saveFile(MultipartFile file, String directoryName) throws IOException {
        String uploadDir = System.getProperty("user.dir") + "/uploads/" + directoryName + "/";
        File dir = new File(uploadDir);
        if (!dir.exists()) dir.mkdirs();

        String originalFilename = file.getOriginalFilename();
        String newFilename = System.currentTimeMillis() + "_" + originalFilename;
        File destination = new File(uploadDir + newFilename);
        file.transferTo(destination);

        // 리턴은 상대경로 (DB 저장용)
        return "/uploads/" + directoryName + "/" + newFilename;
    }
}
