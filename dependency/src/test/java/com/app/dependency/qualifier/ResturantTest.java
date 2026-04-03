package com.app.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ResturantTest {


    @Autowired @Qualifier("vips")
     Resturant resturant;
    @Test
    public void Resturanttest() {
        log.info("resturant {}", resturant);
        log.info("resturant.isSaladbar() : {}", resturant.isSaladbar() );
        log.info("resturant.steakPrice() : {}", resturant.steakPrice() );
    }
}
