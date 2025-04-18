package com.courseconnect.juniedemo.controller;

import com.courseconnect.juniedemo.dto.SummarizeRequest;
import com.courseconnect.juniedemo.exception.GlobalExceptionHandler;
import com.courseconnect.juniedemo.service.TextSummarizerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Tests for TextSummarizerController.
 */
public class TextSummarizerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TextSummarizerService textSummarizerService;

    @InjectMocks
    private TextSummarizerController textSummarizerController;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(textSummarizerController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    /**
     * Test for the summarize endpoint.
     */
    @Test
    public void testSummarize() throws Exception {
        // Given
        String inputText = "This is a test text that needs to be summarized. It should be long enough to meet the validation requirements.";
        String expectedSummary = "Test summary";
        SummarizeRequest request = new SummarizeRequest(inputText);

        // When
        when(textSummarizerService.summarize(anyString())).thenReturn(expectedSummary);

        // Then
        mockMvc.perform(post("/api/summarize")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.summary").value(expectedSummary));
    }

    /**
     * Test for validation error when text is too short.
     */
    @Test
    public void testSummarizeValidationError() throws Exception {
        // Given
        String shortText = "Too short";
        SummarizeRequest request = new SummarizeRequest(shortText);

        // When
        when(textSummarizerService.summarize(shortText)).thenThrow(new IllegalArgumentException("Text is too short"));

        // Then
        mockMvc.perform(post("/api/summarize")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
