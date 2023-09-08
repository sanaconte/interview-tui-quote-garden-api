//package com.tui.tech.interview.quotegarden.configuration;
//
//
//import com.mongodb.BasicDBObject;
//import com.mongodb.DBObject;
//import com.tui.tech.interview.quotegarden.model.Quote;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//@Component
//public class QuoteConverter implements Converter<Quote, DBObject> {
//
//    @Override
//    public DBObject convert(Quote source) {
//        final DBObject dbObject = new BasicDBObject();
//
//        dbObject.put("_id", source.get_id());
//        dbObject.put("quoteText", source.getQuoteText());
//        dbObject.put("quoteAuthor", source.getQuoteAuthor());
//        dbObject.put("quoteGenre", source.getQuoteGenre());
//        dbObject.put("__v", source.get__v());
//        dbObject.removeField("_class");
//        return dbObject;
//    }
//
//
//}
