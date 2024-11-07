package com.courseconnect.app.document;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate lastModifiedDate;
}
