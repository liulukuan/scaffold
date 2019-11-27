package com.llk.scaffold.controller;

import com.llk.scaffold.model.dto.ResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @className: FileManagementController
 * @description:
 * @author: LiuLukuan
 * @date: 2019/11/21 17:05
 */
@Slf4j
@RestController
@RequestMapping("/file")
public class FileManagementController {

    /**
     * 文件上传有个临时路径保存文件的bug，详情见配置文件的location配置
     *
     * @param multipartFile
     * @return
     */
    @PostMapping("/upload")
    public ResponseBean upload(@RequestParam("multipartFile") MultipartFile multipartFile) {

        String fileOriginalName = multipartFile.getOriginalFilename();
        File file = new File(fileOriginalName);
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            log.error("失败：{}", e);
            return new ResponseBean(HttpStatus.BAD_REQUEST.value(), "文件上传失败！", null);
        }
        return new ResponseBean(HttpStatus.OK.value(), "文件上传成功！", null);
    }
}
