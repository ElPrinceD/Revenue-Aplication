package com.test.Revenue.Aplication.v1.dao;


import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Date;

@Data
public class RevenueResponse {
    private Long id;
    private Double amount;
    private Date created_On;
    private Date updated_On;
}
