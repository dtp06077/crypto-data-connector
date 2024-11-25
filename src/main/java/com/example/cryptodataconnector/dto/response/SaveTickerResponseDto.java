package com.example.cryptodataconnector.dto.response;

import com.example.cryptodataconnector.common.ResponseCode;
import com.example.cryptodataconnector.common.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class SaveTickerResponseDto extends ResponseDto {

    private SaveTickerResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    //Http Status 200
    public static ResponseEntity<SaveTickerResponseDto> success() {
        SaveTickerResponseDto result = new SaveTickerResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
