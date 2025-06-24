package org.scoula.config;

import org.scoula.domain.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig2 {
    @Bean
    Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }
    @Bean(name = "miki")
    Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Miki");
        return parrot;
    }
    @Bean
    Parrot parrot3() {
        Parrot parrot = new Parrot();
        parrot.setName("Riki");
        return parrot;
    }
}
