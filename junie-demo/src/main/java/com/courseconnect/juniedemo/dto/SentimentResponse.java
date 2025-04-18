package com.courseconnect.juniedemo.dto;

import com.courseconnect.juniedemo.service.SentimentAnalyzerService.Sentiment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for sentiment analysis response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SentimentResponse {
    
    private Sentiment sentiment;
    private float score;
}