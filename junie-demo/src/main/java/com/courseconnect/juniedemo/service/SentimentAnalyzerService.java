package com.courseconnect.juniedemo.service;

import com.courseconnect.juniedemo.model.AnalysisRecord;
import com.courseconnect.juniedemo.repository.AnalysisRecordRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Service for sentiment analysis using AI.
 * This is a simulated implementation for demo purposes.
 */
@Service
public class SentimentAnalyzerService {

    private final AnalysisRecordRepository repository;
    private final Random random = new Random();

    /**
     * Constructor for SentimentAnalyzerService.
     *
     * @param repository the analysis record repository
     */
    @Autowired
    public SentimentAnalyzerService(AnalysisRecordRepository repository) {
        this.repository = repository;
    }

    /**
     * Analyzes the sentiment of the given text.
     *
     * @param text the text to analyze
     * @return the sentiment analysis result
     */
    public SentimentResult analyzeSentiment(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Text cannot be empty");
        }

        // For demo purposes, we'll simulate a sentiment analysis result
        // In a real application, this would call an AI service
        
        // Generate a random sentiment score between 0 and 1
        float score = random.nextFloat();
        
        // Determine sentiment based on score
        Sentiment sentiment;
        if (score < 0.4) {
            sentiment = Sentiment.NEGATIVE;
        } else if (score < 0.6) {
            sentiment = Sentiment.NEUTRAL;
        } else {
            sentiment = Sentiment.POSITIVE;
        }
        
        SentimentResult result = new SentimentResult(sentiment, score);
        
        // Save the analysis record
        AnalysisRecord record = AnalysisRecord.builder()
                .inputText(text)
                .outputText(result.toString())
                .type(AnalysisRecord.AnalysisType.SENTIMENT_ANALYSIS)
                .build();
        
        repository.save(record);
        
        return result;
    }

    /**
     * Enum representing sentiment types.
     */
    public enum Sentiment {
        POSITIVE, NEGATIVE, NEUTRAL
    }

    /**
     * Class representing a sentiment analysis result.
     */
    @Data
    @AllArgsConstructor
    public static class SentimentResult {
        private Sentiment sentiment;
        private float score;
        
        @Override
        public String toString() {
            return String.format("Sentiment: %s, Score: %.2f", sentiment, score);
        }
    }
}