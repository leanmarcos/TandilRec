package com.tandilrec.TandilRec.modules.user;

import com.fasterxml.jackson.annotation.JsonCreator;

// Advertise: Be VERY careful with deleting/editing this enum. DB data may be extremely affected
public enum UserRole {
        CITIZEN,
        MUNICIPAL,
        ADMIN;

    @JsonCreator
    public static UserRole fromString(String value) {
        try {
            return UserRole.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Invald role: '" + value + "'. Accepted values: CITIZEN, MUNICIPAL, ADMIN"
            );
        }
    }

}
