package com.courseconnect.app.document;

import com.courseconnect.app.document.enums.School;
import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@Document(collection = "course_outlines")
public class CourseOutlineDocument extends BaseDocument {

    private ObjectId courseId;
    private String code;
    private int year;
    private School school;
    private String description;
}
