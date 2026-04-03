package com.app.dependency.di;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Login {
    private final Member member;
}
