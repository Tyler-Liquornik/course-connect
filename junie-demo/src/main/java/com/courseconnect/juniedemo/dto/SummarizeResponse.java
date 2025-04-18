package com.courseconnect.juniedemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for text summarization response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummarizeResponse {
    
    private String summary;
}