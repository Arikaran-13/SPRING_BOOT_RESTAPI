package com.arikaran.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
public class ErrorDetails {
    private Date date;
    private String message;
    private String details;
}
