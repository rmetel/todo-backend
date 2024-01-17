package com.todo.todobackend.controllers;

import com.todo.todobackend.models.App;
import com.todo.todobackend.utils.FileReader;
import com.todo.todobackend.utils.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {
        "http://localhost",
        "http://localhost:80",
        "http://localhost:8080",
        "http://localhost:3000",
        "https://localhost:3000",
        "https://localhost",
        "https://localhost:443",
        "http://212.227.201.99",
        "https://212.227.201.99",
        "http://todo-app.tech/",
        "https://todo-app.tech/"
})
public class AppController {
//    @Autowired
//    private BuildProperties buildProperties;

//    @Value("${git.branch}")
//    private String branch;

    @GetMapping("/version")
    public App getBuildInformation() throws IOException {
        String metaFile = FileReader.getMetaFile();
        String branch = "";
        String version = "";

        if (!metaFile.isEmpty()) {
            branch = Parser.parseTag("branch", metaFile);
            version = Parser.parseTag("version", metaFile);
        }

        return App
                .builder()
                .branch(branch)
                .version(version)
                .deployed(true)
                .build();
    }
}
