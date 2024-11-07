package com.courseconnect.app.document;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Term {
    FALL("Fall Semester"),
    WINTER("Winter Semester"),
    SUMMER("Summer Semester");

    private final String description;
}
