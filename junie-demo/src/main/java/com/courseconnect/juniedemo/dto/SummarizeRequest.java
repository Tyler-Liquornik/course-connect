package com.courseconnect.juniedemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for text summarization request.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummarizeRequest {
    
    @NotBlank(message = "Text cannot be empty")
    @Size(min = 10, max = 10000, message = "Text must be between 10 and 10000 characters")
    private String text;
}