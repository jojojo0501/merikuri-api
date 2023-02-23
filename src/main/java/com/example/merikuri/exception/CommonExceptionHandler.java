package com.example.merikuri.exception;

import com.example.merikuri.common.constant.ResponseCode;
import com.example.merikuri.generated.model.BadRequestResponse;
import com.example.merikuri.generated.model.BadRequestResponseInvalidParamsInner;
import com.example.merikuri.generated.model.NotFoundResponse;
import com.example.merikuri.generated.model.ServerErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 共通のExceptionHandler.
 */
@RestControllerAdvice
public class CommonExceptionHandler {

    /**
     * BadRequestExceptionをハンドリングする.
     *
     * @param e エラー
     * @return レスポンス
     */
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<BadRequestResponse> handleBadRequestException(BadRequestException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new BadRequestResponse().
                        code(ResponseCode.BAD_REQUEST.name())
                        .message(e.getMessage())
                );
    }

    /**
     * MethodArgumentNotValidExceptionをハンドリングする.
     * <p>
     * Open API Generatorでバリデーション時に発生するException
     *
     * @param e エラー
     * @return レスポンス
     */
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

    /**
     * NotFoundExceptionをハンドリングする.
     *
     * @param e エラー
     * @return レスポンス
     */
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new NotFoundResponse().
                        code(ResponseCode.NOT_FOUND.name())
                        .message(e.getMessage())
                );
    }

    /**
     * NotFoundExceptionをハンドリングする.
     *
     * @param e エラー
     * @return レスポンス
     */
    @ExceptionHandler(ServerErrorException.class)
    public ResponseEntity<ServerErrorResponse> handleServerErrorException(ServerErrorResponse e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ServerErrorResponse().
                        code(ResponseCode.SERVER_ERROR.name())
                        .message(e.getMessage())
                );
    }
}
