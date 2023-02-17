package com.example.merikuri.exception;

import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.model.BadRequestResponse;
import com.example.merikuri.model.BadRequestResponseInvalidParamsInner;
import com.example.merikuri.model.NotFoundResponse;
import com.example.merikuri.model.ServerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<BadRequestResponse> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new BadRequestResponse().
                        code(ResponseCode.BAD_REQUEST.name())
                        .message(e.getMessage())
                );
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<BadRequestResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new BadRequestResponse()
                        .code(ResponseCode.BAD_REQUEST.name())
                        .invalidParams(e.getFieldErrors().stream()
                                .map(fieldError ->
                                        new BadRequestResponseInvalidParamsInner()
                                                .name(fieldError.getField())
                                                .reason(fieldError.getDefaultMessage())).collect(Collectors.toList())
                        )
                );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new NotFoundResponse().
                        code(ResponseCode.NOT_FOUND.name())
                        .message(e.getMessage())
                );
    }

    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<ServerErrorResponse> handleServerErrorException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ServerErrorResponse().
                        code(ResponseCode.SERVER_ERROR.name())
                        .message(e.getMessage())
                );
    }
}
