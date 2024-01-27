package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws IOException {
        //把文件的内容存储到本地磁盘上
        String originalFilename = file.getOriginalFilename();
        //需要保证文件名字唯一防止覆盖
        String filename = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存在本地
        /*try {
            file.transferTo(new File("C:\\Users\\周\\Desktop\\files\\"+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        String url = AliOssUtil.uploadFile(filename,file.getInputStream());
        return Result.success(url);
    }
}
