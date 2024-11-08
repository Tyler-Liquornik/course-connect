package com.courseconnect.app.document;

import com.courseconnect.app.document.enums.BreadthCategory;
import com.courseconnect.app.document.enums.School;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Builder
@Document(collection = "subjects")
public class SubjectDocument extends BaseDocument {
    private List<School> schools;
    private BreadthCategory breadthCategory;
    private String subjectCode;
}
