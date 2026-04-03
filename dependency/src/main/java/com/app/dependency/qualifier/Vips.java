package com.app.dependency.qualifier;

import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
//@Qualifier("B") : 이름 변경가능
public class Vips implements Resturant {
    @Override
    public boolean isSaladbar() {
        return false;
    }

    @Override
    public int steakPrice() {
        return 100000;
    }
//    public int steakPrice = Resturant.steakPrice + 30000;
}
