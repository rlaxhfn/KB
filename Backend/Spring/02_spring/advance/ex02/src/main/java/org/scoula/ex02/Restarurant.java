package org.scoula.ex02;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
public class Restarurant {
    @Autowired
    private Chef chef;
}
