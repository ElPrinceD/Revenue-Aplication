package com.test.Revenue.Aplication.v1.controllers;


import com.test.Revenue.Aplication.v1.entities.Revenue;
import com.test.Revenue.Aplication.v1.services.RevenueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/revenue")
@Slf4j
public class RevenueController {

    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        Objects.requireNonNull(revenueService, "revenue Service cannot be null");
        this.revenueService = revenueService;
    }


    @GetMapping
    public Map<String, List<Revenue>> revenuesBySpecificYear(@RequestParam(required = true) int year, HttpServletResponse response, HttpServletRequest request) throws ParseException {
        String requestId = request.getSession().getId();

        log.info("[ " + requestId + " ] about to process request to get revenue by year " + year);

        return revenueService.getByDate(year);

    }









}
