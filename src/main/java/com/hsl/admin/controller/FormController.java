package com.hsl.admin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormController {

    @GetMapping("/form_layouts")
    public String form_layouts() {
        log.info("form_layouts 开始");
        return "form/form_layouts";
    }



    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam(value = "bookGrade",required = false) String bookGrade,
                             @RequestParam(value = "bookOption") String bookOption,
                             @RequestParam(value = "bookVersion",required = false) String bookVersion,
                             @RequestPart(value = "file",required = false) MultipartFile file,
                             Model model,
                             HttpSession session) throws IOException{
        System.out.println(bookGrade);
//
        return "main";
    }

    /**
     * MultipartFile自动封装文件
     *
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("upload 开始");
        log.info("上传的信息{},{},{},{}", email, username, headerImg.getSize(), photos.length);

        if (!headerImg.isEmpty()) {
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\IdeaProjects\\boot-05-web-admin\\src\\main\\resources\\File\\" + originalFilename));
        }
//        String curDir = System.getProperty("user.dir");
//        log.info(curDir);
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\IdeaProjects\\boot-05-web-admin\\src\\main\\resources\\File\\" + originalFilename));
                }
            }
        }
        return "main";
    }
}
