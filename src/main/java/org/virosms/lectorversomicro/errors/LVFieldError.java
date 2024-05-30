package org.virosms.lectorversomicro.errors;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.util.Arrays;

@Data
@Validated
public class LVFieldError {
    @Setter
    @JsonProperty(
            value = "detail",
            index = 1
    )
    private String detail = null;
    @Setter
    @JsonProperty(
            value = "type",
            index = 2
    )
    private String type = null;
    @Setter
    @JsonProperty(
            value = "field",
            index = 3
    )
    private String field;
    @Setter
    @JsonProperty(
            value = "objectName",
            index = 4
    )
    private String objectName;
    @JsonProperty(
            value = "rejectedValue",
            index = 5
    )
    private Object rejectedValue = null;
    @JsonProperty(
            value = "parameters",
            index = 6
    )
    private Object[] parameters;

    public LVFieldError() {
    }


    public LVFieldError(String detail, String type, String objectName, String field, Object rejectedValue, Object[] parameters) {
        this.type = type;
        this.objectName = objectName;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.detail = detail;
        this.parameters = parameters;
    }

    /**
     * Create a new LVFieldError.
     *
     * @param type the error type
     * @return the LVFieldError
     */
    public static LVFieldError of(LeverErrorType type) {
        return (new LVFieldError()).type(type);
    }

    public void setParameters(Object... parameters) {
        this.parameters = parameters;
    }

    /**
     * Set the parameters.
     *
     * @param parameters the parameters
     * @return the LVFieldError
     */
    public LVFieldError parameters(Object... parameters) {
        this.parameters = parameters;
        return this;
    }

    public LVFieldError field(String field) {
        this.field = field;
        return this;
    }

    /**
     * Set the object name.
     *
     * @param objectName the object name
     * @return the LVFieldError
     */
    public LVFieldError objectName(String objectName) {
        this.objectName = objectName;
        return this;
    }

    /**
     * Set the detail.
     *
     * @param type the type
     * @return the LVFieldError
     */
    public LVFieldError type(String type) {
        this.type = type;
        return this;
    }

    public LVFieldError detail(String detail) {
        this.detail = detail;
        return this;
    }

    /**
     * Set the rejected value.
     *
     * @param rejectedValue the rejected value
     * @return the LVFieldError
     */
    public LVFieldError rejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
        return this;
    }

    public LVFieldError setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
        return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the LVFieldError
     */
    public LVFieldError type(LeverErrorType type) {
        this.setType(type.toString());
        this.setDetail(type.getDetail());
        return this;
    }

    /**
     * hashCode method.
     *
     * @return the hash code
     */
    public int hashCode() {
        int result = 1;
        result = 31 * result + (this.type == null ? 0 : this.type.hashCode());
        result = 31 * result + (this.detail == null ? 0 : this.detail.hashCode());
        result = 31 * result + (this.field == null ? 0 : this.field.hashCode());
        result = 31 * result + (this.objectName == null ? 0 : this.objectName.hashCode());
        result = 31 * result + Arrays.deepHashCode(this.parameters);
        result = 31 * result + (this.rejectedValue == null ? 0 : this.rejectedValue.hashCode());
        return result;
    }

    /**
     * equals method.
     *
     * @param obj the object to compare
     * @return true if the objects are equal, false otherwise
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            LVFieldError other = (LVFieldError) obj;
            if (this.type == null) {
                if (other.type != null) {
                    return false;
                }
            } else if (!this.type.equals(other.type)) {
                return false;
            }
            if (this.detail == null) {
                if (other.detail != null) {
                    return false;
                }
            } else if (!this.detail.equals(other.detail)) {
                return false;
            }
            if (this.field == null) {
                if (other.field != null) {
                    return false;
                }
            } else if (!this.field.equals(other.field)) {
                return false;
            }
            if (this.objectName == null) {
                if (other.objectName != null) {
                    return false;
                }
            } else if (!this.objectName.equals(other.objectName)) {
                return false;
            }
            if (!Arrays.deepEquals(this.parameters, other.parameters)) {
                return false;
            } else {
                if (this.rejectedValue == null) {
                    return other.rejectedValue == null;
                } else return this.rejectedValue.equals(other.rejectedValue);
            }
        }
    }

    public String toString() {
        String var1001 = this.detail;
        return "LVFieldError [detail=" + var1001 + ", type=" + this.type + ", field="
                + this.field + ", objectName=" + this.objectName + ", rejectedValue=" + this.rejectedValue
                + ", parameters=" + Arrays.toString(this.parameters) + "]";
    }
}