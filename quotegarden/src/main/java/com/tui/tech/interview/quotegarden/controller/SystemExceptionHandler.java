package com.tui.tech.interview.quotegarden.controller;

import com.tui.tech.interview.quotegarden.model.ProblemJson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class SystemExceptionHandler extends ResponseEntityExceptionHandler {

/*    @ExceptionHandler(DatabaseNotFoundException::class)
    @ResponseBody
    public ResponseEntity<ProblemJson>  handleNotFoundException(DatabaseNotFoundException ex, WebRequest request) {
        return  ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(
                        ProblemJson(
                                Links.forApiError("NotFoundException").toString(),
                                ex.title, ex.detail, null
                        )
                );
    }*/

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseEntity<ProblemJson> handleAllExceptions(Throwable ex, WebRequest request){

        return  ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_PROBLEM_JSON)
                .body(new ProblemJson(ex.toString(), ex.getMessage(), null));
    }


}
