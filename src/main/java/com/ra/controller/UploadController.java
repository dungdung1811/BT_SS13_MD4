package com.ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

@Controller
public class UploadController {
    @RequestMapping("/upload")
    public String upload(){
        return "upload";
    }
    @RequestMapping("save-file")
    public void save(@RequestParam("img")MultipartFile file, HttpServletRequest request){
        String path = request.getServletContext().getRealPath("uploads/images");
        String fileName = file.getOriginalFilename();
        File destination = new File(path+"/"+fileName);
        try {

            Files.write(destination.toPath(),file.getBytes(), StandardOpenOption.CREATE);
//            fileImage.transferTo(destination);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
