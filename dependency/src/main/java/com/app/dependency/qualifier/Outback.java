package com.app.dependency.qualifier;


import lombok.Data;
import org.springframework.stereotype.Component;


@Component
@Data
public class Outback implements Resturant {
    @Override
    public boolean isSaladbar() {
        return false;
    }

    @Override
    public int steakPrice() {
        return 500000;
    }
}
