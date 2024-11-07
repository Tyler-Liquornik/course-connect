package com.courseconnect.app.document;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Data
@Builder
@Document(collection = "jobs")
public class JobDocument {

    @Id
    private ObjectId id;

    private String linkedinJobId;
    private String linkedinUrl;
    private String jobTitle;
    private String company;
    private String companyLinkedinUrl;
    private String location;
    private LocalDate postedDate;
    private String jobDescription;
    private String searchQuery;

    @CreatedDate
    private LocalDate createdDate;
}
