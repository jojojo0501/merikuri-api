package com.example.merikuri.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeleteFlg {
    FLG_ON(true),
    FLG_OFF(false);

    private Boolean value;

}
