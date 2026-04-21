package com.tandilrec.TandilRec.shared.utils.ErrorHandling;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class ErrorDTOResponse {
    private String errorCode;
    private String errorMessage;
    private int status;
    private Instant timestamp;
    private String path;
}
