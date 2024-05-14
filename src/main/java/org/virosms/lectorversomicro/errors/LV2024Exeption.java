package org.virosms.lectorversomicro.errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;

import java.io.Serial;

@Validated
@JsonIgnoreProperties(
        {"mostSpecificCause", "suppressed", "stackTrace", "rootCause"}
)
public class LV2024Exeption extends Exception{
    @Serial
    private static final long serialVersionUID = 10001L;
    @JsonProperty("type")
    private String type = null;
    @JsonProperty("title")
    private String title = null;
    @JsonProperty("detail")
    private String detail = null;
    @JsonProperty("status")
    private Integer status = null;
    @JsonProperty("instance")
    private String instance = null;


    public LV2024Exeption() {
    }

    public LV2024Exeption(Throwable cause) {
        super(cause);
    }

    public LV2024Exeption(String message) {
        super(message);
    }

    LV2024Exeption title(String title) {
        this.title = title;
        return this;
    }

    LV2024Exeption detail(String detail) {
        this.detail = detail;
        return this;
    }

    LV2024Exeption status(Integer status) {
        this.status = status;
        return this;
    }

    LV2024Exeption status(HttpStatus status) {
        return this.status(status.value());
    }

    public String toString() {
        return "class LVExeption {\n" +
                "    type: " + this.toIndentedString(this.type) + "\n" +
                "    title: " + this.toIndentedString(this.title) + "\n" +
                "    detail: " + this.toIndentedString(this.detail) + "\n" +
                "    status: " + this.toIndentedString(this.status) + "\n" +
                "    instance: " + this.toIndentedString(this.instance) + "\n" +
                "}";
    }
    protected String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n");
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            LV2024Exeption lV2024Exeption = (LV2024Exeption)o;
            return super.equals(o) && this.type.equals(lV2024Exeption.type) && this.title.equals(lV2024Exeption.title) && this.detail.equals(lV2024Exeption.detail) && this.status.equals(lV2024Exeption.status) && this.instance.equals(lV2024Exeption.instance);
        } else {
            return false;
        }
    }

    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (this.type == null ? 0 : this.type.hashCode());
        result = 31 * result + (this.title == null ? 0 : this.title.hashCode());
        result = 31 * result + (this.detail == null ? 0 : this.detail.hashCode());
        result = 31 * result + (this.status == null ? 0 : this.status.hashCode());
        result = 31 * result + (this.instance == null ? 0 : this.instance.hashCode());
        return result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
}
