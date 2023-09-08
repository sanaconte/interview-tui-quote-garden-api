package com.tui.tech.interview.quotegarden.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




//@Document(collection = "quote")
@Document
//@Data
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
public class Quote {
    @Id
    public String _id;
    public String quoteText;
    public String quoteAuthor;
    public String quoteGenre;
    public Integer __v;

    public Quote(String _id, String quoteText, String quoteAuthor, String quoteGenre, Integer __v) {
        this._id = _id;
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
        this.quoteGenre = quoteGenre;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getQuoteText() {
        return quoteText;
    }

    public void setQuoteText(String quoteText) {
        this.quoteText = quoteText;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteGenre() {
        return quoteGenre;
    }

    public void setQuoteGenre(String quoteGenre) {
        this.quoteGenre = quoteGenre;
    }

    public Integer get__v() {
        return __v;
    }

    public void set__v(Integer __v) {
        this.__v = __v;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "_id='" + _id + '\'' +
                ", quoteText='" + quoteText + '\'' +
                ", quoteAuthor='" + quoteAuthor + '\'' +
                ", quoteGenre='" + quoteGenre + '\'' +
                ", __v=" + __v +
                '}';
    }
}
