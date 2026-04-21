package com.app.restful.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.URISyntaxException;

@Slf4j
@SpringBootTest
public class OpenApiServiceTest {

    @Autowired
    private OpenApiService openApiService;

    @Test
    public void fetchDataTest() throws IOException {
        openApiService.fetchData();
    }

    @Test
    public void fetchDataTest2() throws IOException, URISyntaxException {
        openApiService.fetchData2();
    }
}
