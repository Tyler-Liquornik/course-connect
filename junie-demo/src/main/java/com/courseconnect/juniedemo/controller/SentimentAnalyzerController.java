package com.courseconnect.juniedemo.controller;

import com.courseconnect.juniedemo.dto.SentimentResponse;
import com.courseconnect.juniedemo.service.SentimentAnalyzerService;
import com.courseconnect.juniedemo.service.SentimentAnalyzerService.SentimentResult;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for sentiment analysis endpoints.
 */
@RestController
@RequestMapping("/api")
@Validated
public class SentimentAnalyzerController {

    private final SentimentAnalyzerService sentimentAnalyzerService;

    /**
     * Constructor for SentimentAnalyzerController.
     *
     * @param sentimentAnalyzerService the sentiment analyzer service
     */
    @Autowired
    public SentimentAnalyzerController(SentimentAnalyzerService sentimentAnalyzerService) {
        this.sentimentAnalyzerService = sentimentAnalyzerService;
    }

    /**
     * Endpoint for sentiment analysis.
     *
     * @param text the text to analyze
     * @return the sentiment response
     */
    @GetMapping("/sentiment")
    public ResponseEntity<SentimentResponse> analyzeSentiment(
            @RequestParam @NotBlank(message = "Text cannot be empty") 
            @Size(min = 1, max = 1000, message = "Text must be between 1 and 1000 characters") String text) {
        
        SentimentResult result = sentimentAnalyzerService.analyzeSentiment(text);
        return ResponseEntity.ok(new SentimentResponse(result.getSentiment(), result.getScore()));
    }
}