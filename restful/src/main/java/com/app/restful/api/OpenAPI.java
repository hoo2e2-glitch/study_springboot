package com.app.restful.api;

import com.app.restful.domain.dto.ApiResponseDTO;
import com.app.restful.domain.dto.CongestionDTO;
import com.app.restful.domain.dto.PetTourDTO;
import com.app.restful.service.OpenApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/api/open-api")
@RestController
@RequiredArgsConstructor
public class OpenAPI {

    private final OpenApiService openApiService;

    @GetMapping("/pet-tuor-list")
    public ResponseEntity<ApiResponseDTO<List<PetTourDTO>>> getOpenApiService() throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("아아아", openApiService.fetchData()));
    }

    @GetMapping("/congestion-station")
    public ResponseEntity<ApiResponseDTO<CongestionDTO>> setOpenApiService() throws IOException, URISyntaxException {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseDTO.of("123", openApiService.fetchData2()));
    }

}
