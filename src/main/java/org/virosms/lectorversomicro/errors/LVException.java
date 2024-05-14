package org.virosms.lectorversomicro.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.virosms.lectorversomicro.repository.LVDomain;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Validated
@JsonIgnoreProperties(
        {"mostSpecificCause", "suppressed", "stackTrace", "rootCause"}
)
@Data
public class LVException extends LV2024Exeption{
    @Serial
    private static final long serialVersionUID = 10001L;
    private String source = null;
    @JsonProperty("parameters")
    private @Valid List<Object> parameters = null;
    @JsonProperty("translated")
    private boolean translated = false;
    @JsonProperty("errors")
    private @Valid List<LVFieldError> errors = null;
    @JsonProperty("additionalInformation")
    private @Valid Map<String, Object> additionalInformation = null;
    @JsonProperty("stackTrace")
    private String stackTraceStr;

    public static LVException of(Throwable cause) {
        return new LVException(cause.getMessage(), wrapCause(cause), null);
    }
    public static LVException of(LeverErrorType errorType) {
        return (new LVException(errorType.getDetail(), null, null)).type(errorType);
    }

    protected LVException(@JsonProperty("message") String message, @JsonProperty("cause") LVException cause, @JsonProperty("parameters") List<Object> parameters) {
        super(message);
        Throwable lvCause = wrapCause(cause);
        this.initCause(lvCause);
        this.setSource(LVAppGlobalInfo.getAplicationName());
        this.setDetail(message);
        this.setParameters(parameters);
    }

    /**
     * Wrap a non-LVException cause into an LVException.
     * @param nonLvException the non-LVException cause
     * @return the LVException
     */
    private static LVException wrapCause(Throwable nonLvException) {
        if(nonLvException != null && !(nonLvException instanceof LVException)) {
            String urlName = toHumanUrl(nonLvException.getClass());
            if (nonLvException.getMessage() != null) {
                urlName = urlName + "-" + toHumanUrl(nonLvException.getMessage());
            }

            LVException res = (LVException) (new LVException(nonLvException.getMessage(), wrapCause(nonLvException.getCause()), null)).detail(nonLvException.toString());
            res.setStackTrace(nonLvException.getStackTrace());
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            res.setType(LVDomain.ARCHICTECTURE.getValue() + "/" + urlName);
            return res;
        }else {
            return (LVException) nonLvException;
        }
    }

    /**
     * Convert a class to a URL name.
     * @param c the class
     * @return the URL name
     */
    private static String toHumanUrl(Class<?> c) {
        String str = c.getCanonicalName();
        str = str.replaceAll("\\.", "-");
        str = str.replaceAll("[^a-z0-9\\-]", "-$1");
        str = str.replaceAll("^-", "");
        str = str.toLowerCase();
        return str;
    }

    /**
     * Convert a string to a URL name.
     * @param str the string
     * @return the URL name
     */
    private static String toHumanUrl(String str) {
        str = str.toLowerCase();
        str = str.replaceAll("[^a-z0-9]", "-");
        str = str.replaceAll("(-)\\1+", "$1");
        return str;
    }

    public LVException type(LeverErrorType type) {
        this.setType(type.getType());
        this.setStatus(type.getStatus());
        this.setDetail(type.getDetail());
        return this;
    }

    public LVException parameter(Object parameterItem) {
        if(this.parameters == null) {
            this.parameters = new ArrayList<>();
        }

        this.parameters.add(parameterItem);
        return this.clone(false);
    }

    public LVException clone(boolean removeCloneIfExists){
        LVException outputException = this.rootClone(removeCloneIfExists);
        outputException.setType(this.getType());
        outputException.setStatus(this.getStatus());
        outputException.setDetail(this.getDetail());
        outputException.setInstance(this.getInstance());
        outputException.setSource(this.getSource());
        outputException.setErrors(this.getErrors());
        outputException.setTitle(this.getTitle());
        outputException.setTranslated(this.isTranslated());
        outputException.setAdditionalInformation(this.getAdditionalInformation());
        outputException.setStackTraceStr(this.getStackTraceStr());
        return outputException;
    }

    public LVException rootClone(boolean removeCauseIfExist){
        LVException causeException = null;

        if (!removeCauseIfExist && this.getCause() != null) {
            causeException = (LVException) this.getCause();
        }

        if (causeException != null) {
            causeException = causeException.clone(false);
        }

        return new LVException(this.getMessage(), causeException, this.getParameters());
    }

}
