package com.tandilrec.TandilRec.shared.utils.ErrorHandling.HandleSpecificExceptions;

import com.tandilrec.TandilRec.shared.utils.ErrorHandling.BaseException;
import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public NotFoundException(String message, String errorCode) {
        super(message, errorCode, HttpStatus.NOT_FOUND);
    }

}
