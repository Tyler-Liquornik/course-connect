package com.courseconnect.juniedemo.controller;

import com.courseconnect.juniedemo.model.AnalysisRecord;
import com.courseconnect.juniedemo.repository.AnalysisRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller for analysis history endpoints.
 */
@RestController
@RequestMapping("/api")
public class HistoryController {

    private final AnalysisRecordRepository repository;

    /**
     * Constructor for HistoryController.
     *
     * @param repository the analysis record repository
     */
    @Autowired
    public HistoryController(AnalysisRecordRepository repository) {
        this.repository = repository;
    }

    /**
     * Endpoint to fetch the last 10 analyses.
     *
     * @return the list of analysis records
     */
    @GetMapping("/history")
    public ResponseEntity<List<AnalysisRecord>> getHistory() {
        List<AnalysisRecord> history = repository.findRecentAnalyses(10);
        return ResponseEntity.ok(history);
    }
}