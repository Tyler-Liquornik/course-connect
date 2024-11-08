package com.courseconnect.app.document;

import lombok.Builder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Builder
@Document(collection = "courses")
public class CourseDocument extends BaseDocument {

    private List<ObjectId> courseOutlineIds;
    private int number;
    private List<Character> suffix;
    private ObjectId subjectId;
    private String description;
}
