package io.shey.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {
    @GetMapping("/news")
    @PreAuthorize("hasRole('ROLE_SYS_GUESTA')")
    public String getNews() {
        return "News";
    }
}
