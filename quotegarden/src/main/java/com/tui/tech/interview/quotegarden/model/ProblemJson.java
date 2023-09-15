package com.tui.tech.interview.quotegarden.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Arrays;
import java.util.List;

@JsonPropertyOrder(value = { "type", "title", "detail", "instance" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProblemJson {

    private String title;
    private String detail;
    private String instance;
    private String type;

    public ProblemJson(String title, String detail, String instance) {
        this.detail = title;
        this.detail = detail;
        this.instance = instance;
        this.type = "about:blank";
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

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
