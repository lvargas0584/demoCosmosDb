package com.bcp.democosmosdb.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public class BaseController {
    public <T> ResponseEntity buildSuccessResponse(List<T> list) {
        return ResponseEntity.accepted().body(list);
    }

    public <T> ResponseEntity buildSuccessResponse(T data) {
        return ResponseEntity.accepted().body(data);
    }


    public <T> ResponseEntity buildSuccessResponse() {
        return ResponseEntity.ok().build();
    }

    public <T> ResponseEntity buildErrorResponse() {
        return ResponseEntity.notFound().build();
    }
}
