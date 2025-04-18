package com.courseconnect.juniedemo.controller;

import com.courseconnect.juniedemo.dto.SummarizeRequest;
import com.courseconnect.juniedemo.dto.SummarizeResponse;
import com.courseconnect.juniedemo.service.TextSummarizerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for text summarization endpoints.
 */
@RestController
@RequestMapping("/api")
public class TextSummarizerController {

    private final TextSummarizerService textSummarizerService;

    /**
     * Constructor for TextSummarizerController.
     *
     * @param textSummarizerService the text summarizer service
     */
    @Autowired
    public TextSummarizerController(TextSummarizerService textSummarizerService) {
        this.textSummarizerService = textSummarizerService;
    }

    /**
     * Endpoint for text summarization.
     *
     * @param request the summarize request
     * @return the summarize response
     */
    @PostMapping("/summarize")
    public ResponseEntity<SummarizeResponse> summarize(@Valid @RequestBody SummarizeRequest request) {
        String summary = textSummarizerService.summarize(request.getText());
        return ResponseEntity.ok(new SummarizeResponse(summary));
    }
}