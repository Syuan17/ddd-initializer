package com.cic.irc.dddinitializer.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitializerService {

    @GetMapping("initializer")
    public void initializer(@RequestParam(value = "group", defaultValue = "com.example") String group,
                            @RequestParam(value = "artifact", defaultValue = "demo") String artifact,
                            @RequestParam(value = "description", defaultValue = "Demo project") String description,
                            @RequestParam(value = "version", defaultValue = "0.0.1-SNAPSHOT") String version) {
        group = group.toLowerCase();
        artifact = artifact.toLowerCase();


    }

}
