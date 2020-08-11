package com.linda.jwt.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRespDto<T> {
 private int statusCode; //1 정상, -1실패, 0변경 안됨
 private T data;
}
