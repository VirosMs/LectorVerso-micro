package org.virosms.lectorversomicro.errors;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public class LeverErrorType extends Exception {


    private final String url;
    private final String domain;
    private final String detail;
    private final Integer status;


    public LeverErrorType(String url, String domain, String detail, Integer status) {
        this.url = url;
        this.domain = domain;
        this.detail = detail;
        this.status = status;
    }

    public static LeverErrorType of(HttpStatus status, String domain, String url, String detail) {
        return new LeverErrorType(url, domain, detail, status.value());
    }

    public static LeverErrorType of(HttpStatus status, String url, String domain) {
        return new LeverErrorType(url, domain, null, status.value());
    }

    public static LeverErrorType of(HttpStatus status, String url) {
        return new LeverErrorType(url, null, null, status.value());
    }

    public static LeverErrorType of(HttpStatus status) {
        return new LeverErrorType(null, null, null, status.value());
    }

    public static LeverErrorType of(String url, String domain, String detail) {
        return new LeverErrorType(url, domain, detail, null);
    }

    public static LeverErrorType of(String url, String domain) {
        return new LeverErrorType(url, domain, null, null);
    }

    public String getType(){
        return this.domain + this.getUrl();
    }


}
