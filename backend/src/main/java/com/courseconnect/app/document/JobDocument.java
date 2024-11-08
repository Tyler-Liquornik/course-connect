package com.courseconnect.app.document;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Builder
@Document(collection = "jobs")
public class JobDocument extends BaseDocument {

    private String linkedinJobId;
    private String linkedinUrl;
    private String jobTitle;
    private String company;
    private String companyLinkedinUrl;
    private String location;
    private LocalDate postedDate;
    private String jobDescription;
    private String searchQuery;
}
