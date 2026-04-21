package com.tandilrec.TandilRec.shared.utils.ErrorHandling.HandleSpecificExceptions;

import com.tandilrec.TandilRec.shared.utils.ErrorHandling.BaseException;
import org.springframework.http.HttpStatus;

public class ExistingResource extends BaseException {
    public ExistingResource(String message, String errorCode) {
        super(message, errorCode, HttpStatus.BAD_REQUEST);
    }
}
