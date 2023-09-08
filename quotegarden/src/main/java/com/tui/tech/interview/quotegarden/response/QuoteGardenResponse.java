package com.tui.tech.interview.quotegarden.response;


import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class QuoteGardenResponse {
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int statusCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public int getTotalQuotes() {
        return totalQuotes;
    }

    public void setTotalQuotes(int totalQuotes) {
        this.totalQuotes = totalQuotes;
    }

    public List<QuoteData> getData() {
        return data;
    }

    public void setData(List<QuoteData> data) {
        this.data = data;
    }


    public String message;
    public Pagination pagination;
    public int totalQuotes;
    public List<QuoteData> data;
}


