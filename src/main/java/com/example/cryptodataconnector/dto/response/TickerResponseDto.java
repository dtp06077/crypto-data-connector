package com.example.cryptodataconnector.dto.response;

import com.example.cryptodataconnector.common.ResponseCode;
import com.example.cryptodataconnector.common.ResponseMessage;

public class TickerResponseDto extends ResponseDto {

    private TickerResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

}
