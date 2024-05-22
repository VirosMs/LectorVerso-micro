package org.virosms.lectorversomicro.errors;

import org.springframework.http.HttpStatus;

public interface LectorVersoExceptions {

    String DOMAIN = "lectorverso";

    LeverErrorType PARAMETER_REQUIRED = LeverErrorType.of(HttpStatus.NOT_FOUND, DOMAIN, "/para-required", "Parameter is required");
    LeverErrorType USER_NOT_FOUND = LeverErrorType.of(HttpStatus.NOT_FOUND, DOMAIN, "/not-found", "User not found");
    LeverErrorType USER_ALREADY_EXISTS = LeverErrorType.of(HttpStatus.CONFLICT, DOMAIN, "/conflict", "User already exists");
    LeverErrorType USER_INVALID = LeverErrorType.of(HttpStatus.BAD_REQUEST, DOMAIN, "/bad-request", "Invalid user");
    LeverErrorType USER_NOT_CREATED = LeverErrorType.of(HttpStatus.INTERNAL_SERVER_ERROR, DOMAIN, "/internal-server-error", "User not created");
    LeverErrorType USER_NOT_UPDATED = LeverErrorType.of(HttpStatus.INTERNAL_SERVER_ERROR, DOMAIN, "/internal-server-error", "User not updated");
    LeverErrorType USER_NOT_DELETED = LeverErrorType.of(HttpStatus.INTERNAL_SERVER_ERROR, DOMAIN, "/internal-server-error", "User not deleted");
    LeverErrorType USER_NOT_DELETED_NOT_FOUND = LeverErrorType.of(HttpStatus.NOT_FOUND, DOMAIN, "/not-found", "User not found to delete");
    LeverErrorType ERROR_GENERIC = LeverErrorType.of(HttpStatus.INTERNAL_SERVER_ERROR, DOMAIN, "/internal-server-error", "Error generic");
    LeverErrorType ERROR_TO_MAPPING = LeverErrorType.of(HttpStatus.INTERNAL_SERVER_ERROR, DOMAIN, "/internal-server-error", "Error to mapping");
    LeverErrorType ERROR_TO_MAPPING_USER = LeverErrorType.of(HttpStatus.INTERNAL_SERVER_ERROR, DOMAIN, "/internal-server-error", "Error to mapping user");
    LeverErrorType ERROR_CANNOT_BE_NULL = LeverErrorType.of(HttpStatus.BAD_REQUEST, DOMAIN, "/internal-server-error", "Cannot be null");
    LeverErrorType INVALID_USERNAME = LeverErrorType.of(HttpStatus.BAD_REQUEST, DOMAIN, "/invalid-username", "Invalid username");
}
