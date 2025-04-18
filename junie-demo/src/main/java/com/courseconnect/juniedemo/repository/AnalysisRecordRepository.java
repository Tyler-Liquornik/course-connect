package com.courseconnect.juniedemo.repository;

import com.courseconnect.juniedemo.model.AnalysisRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for AnalysisRecord entity.
 */
@Repository
public interface AnalysisRecordRepository extends JpaRepository<AnalysisRecord, Long> {

    /**
     * Find the most recent analysis records, limited by count.
     *
     * @param limit the maximum number of records to return
     * @return a list of the most recent analysis records
     */
    @Query("SELECT a FROM AnalysisRecord a ORDER BY a.timestamp DESC")
    List<AnalysisRecord> findRecentAnalyses(int limit);

    /**
     * Find analysis records by type.
     *
     * @param type the type of analysis
     * @return a list of analysis records of the specified type
     */
    List<AnalysisRecord> findByTypeOrderByTimestampDesc(AnalysisRecord.AnalysisType type);
}