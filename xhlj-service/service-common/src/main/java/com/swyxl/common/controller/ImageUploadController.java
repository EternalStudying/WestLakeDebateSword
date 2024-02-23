package com.swyxl.common.controller;

import com.swyxl.common.service.ImageUploadService;
import com.swyxl.model.vo.common.Result;
import com.swyxl.model.vo.common.ResultCodeEnum;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.InputStream;

@RestController
@RequestMapping("/service/common")
public class ImageUploadController {

    @Autowired
    private ImageUploadService imageUploadService;


    @PostMapping("/auth/imageUpload")
    public Result imageUpload(MultipartFile image, HttpServletRequest request){
        String type = request.getHeader("type");
        String url = imageUploadService.upload(image, type);
        return Result.build(url,ResultCodeEnum.SUCCESS);
    }
}
