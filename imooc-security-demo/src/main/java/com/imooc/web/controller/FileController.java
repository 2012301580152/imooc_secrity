package com.imooc.web.controller;

import com.imooc.dto.FileInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author 86187
 * @Date 2018/12/24 16:53
 * @Version 1.0
 */
@RestController
@RequestMapping("/file")
public class FileController {

    String folder = "./";

    @PostMapping
    public FileInfo upload(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());



        File localFile = new File(folder, new Date().getTime()+".txt");


        file.transferTo(localFile);

        return new FileInfo(localFile.getAbsolutePath());

    }

    @GetMapping("/{id}")
    public void download(HttpServletRequest request, HttpServletResponse response, @PathVariable String id) throws IOException {

        try (
                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = response.getOutputStream();
                ){
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=text.txt");

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();

        }

    }

}
