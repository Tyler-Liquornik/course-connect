package com.courseconnect.juniedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for web pages.
 * Serves the React frontend for all non-API requests.
 */
@Controller
public class WebController {

    /**
     * Forward all routes to the React frontend.
     * This allows the React router to handle client-side routing.
     *
     * @return the index.html file from static resources
     */
    @GetMapping(value = {"", "/", "/{path:^(?!api|error).*$}/**"})
    public String forward() {
        return "forward:/index.html";
    }
}
