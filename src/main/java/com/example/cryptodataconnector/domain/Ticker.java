package com.example.cryptodataconnector.domain;

import com.example.cryptodataconnector.dto.request.TickerRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Ticker {

    @Id @GeneratedValue
    private long id;

    private double openingPrice;
    private double highPrice;
    private double lowPrice;
    private double tradePrice;
    private double prevClosingPrice;
    private double highest52WeekPrice;
    private double lowest52WeekPrice;
    private double tradeVolume;
    private double accTradeVolume;
    private double accTradePrice;
    private String tradeDate;
    private String tradeTime;
    private long tradeTimeStamp;

    public Ticker(TickerRequestDto requestDto) {
        this.openingPrice = requestDto.getOpeningPrice();
        this.highPrice = requestDto.getHighPrice();
        this.lowPrice = requestDto.getLowPrice();
        this.tradePrice = requestDto.getTradePrice();
        this.prevClosingPrice = requestDto.getPrevClosingPrice();
        this.highest52WeekPrice = requestDto.getHighest52WeekPrice();
        this.lowest52WeekPrice = requestDto.getLowest52WeekPrice();
        this.tradeVolume = requestDto.getTradeVolume();
        this.accTradeVolume = requestDto.getAccTradeVolume();
        this.accTradePrice = requestDto.getAccTradePrice();
        this.tradeDate = requestDto.getTradeDate();
        this.tradeTime = requestDto.getTradeTime();
        this.tradeTimeStamp = requestDto.getTradeTimeStamp();
    }
}
