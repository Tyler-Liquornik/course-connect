package com.courseconnect.juniedemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entity to store analysis records including input text, output text, analysis type, and timestamp.
 */
@Entity
@Table(name = "analysis_records")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalysisRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "input_text", columnDefinition = "TEXT")
    private String inputText;

    @Column(name = "output_text", columnDefinition = "TEXT")
    private String outputText;

    @Enumerated(EnumType.STRING)
    @Column(name = "analysis_type")
    private AnalysisType type;

    @Column(name = "created_at")
    private LocalDateTime timestamp;

    /**
     * Enum representing the type of analysis performed.
     */
    public enum AnalysisType {
        SUMMARIZATION,
        SENTIMENT_ANALYSIS
    }

    /**
     * Pre-persist hook to set the timestamp before saving.
     */
    @PrePersist
    protected void onCreate() {
        timestamp = LocalDateTime.now();
    }
}