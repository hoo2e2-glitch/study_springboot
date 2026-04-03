package com.app.dependency.qualifier;

import com.app.dependency.qualifier.Computer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ComputerTest {

    @Autowired @Qualifier("laptop")
    private Computer computer;

    @Test
    public void Computertest(){
        log.info("computer {}", computer );
        log.info("computer.getScreemSize() : {} ", computer.getScreenSize());
    }


}
