package com.app.oauth.api;

import com.app.oauth.domain.dto.response.ApiResponseDTO;
import com.app.oauth.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/private/api/file")
@RequiredArgsConstructor
public class FileApi {

    private final FileService fileService;


    // 유저 썸네일 업로드 서비스
    // 파일 관련 컨드롤러

    // 1개 업로드
    @PostMapping("/upload-file")
    public ResponseEntity<ApiResponseDTO> upload(@RequestParam("uploadFile") MultipartFile uploadFile) {

        return ResponseEntity.status(HttpStatus.OK).body(fileService.uploadFile(uploadFile));

    }

    // 여러 개 업로드
    @PostMapping("/upload-files")
    public ResponseEntity<ApiResponseDTO> uploads(@RequestParam("uploadFiles") List<MultipartFile> uploadFiles) {

        return ResponseEntity.status(HttpStatus.OK).body(fileService.uploadFiles(uploadFiles));

    }

}
