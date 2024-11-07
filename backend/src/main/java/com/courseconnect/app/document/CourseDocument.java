package com.courseconnect.app.document;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@Document(collection = "courses")
public class CourseDocument {

    @Id
    private ObjectId id;

    private String faculty;
    private String prefix;
    private int number;
    private char suffix;
    private List<CourseDocument> antiRequisiteCourseIds;
    private List<CourseDocument> preRequisiteCourseIds;

    @CreatedDate
    private LocalDate createdDate;
    @LastModifiedDate
    private LocalDate lastModifiedDate;
}
