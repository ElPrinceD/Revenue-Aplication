package com.test.Revenue.Aplication.v1.services;

import com.test.Revenue.Aplication.v1.entities.Revenue;
import com.test.Revenue.Aplication.v1.repositories.RevenueRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class RevenueService {

    private final RevenueRepository revenueRepository;

    public RevenueService(RevenueRepository revenueRepository) {
        Objects.requireNonNull(revenueRepository, " revenue repository cannot be null");
        this.revenueRepository = revenueRepository;
    }

    public Map<String, List<Revenue>> getByDate(int year) throws ParseException {
        return revenuesByEachMonth(year);

    }

    public Map<String, List<Revenue>> revenuesByEachMonth(int year){

        HashMap<String, List<Revenue>> monthlyRevenue = new HashMap<>();
        List<String> months = new ArrayList<>(Arrays.asList("January", "February", "March","April","May", "June", "July", "August", "September","October", "November", "December"));

        //List<List<Revenue>> revenueList = new ArrayList<>();
        for (int i = 1; i < 13; i++) {

            List<Revenue> revenues = revenueRepository.AllBySpecificMonth(year, i);
           // revenueList.add(revenues);
            monthlyRevenue.put(months.get(i-1),revenues);

        }


        return monthlyRevenue;
    }





    }












