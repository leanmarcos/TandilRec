package com.tandilrec.TandilRec.shared.utils.ErrorHandling.HandleSpecificExceptions;

import com.tandilrec.TandilRec.shared.utils.ErrorHandling.BaseException;
import org.springframework.http.HttpStatus;

public class DownDatabase extends BaseException {
    public DownDatabase(String message, String errorCode) {
        super(message, errorCode, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
