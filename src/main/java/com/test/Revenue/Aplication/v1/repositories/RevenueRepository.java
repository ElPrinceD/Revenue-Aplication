package com.test.Revenue.Aplication.v1.repositories;

import com.test.Revenue.Aplication.v1.entities.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {




    @Query("Select r from Revenue r where Year(r.createdOn)= :year")
    List<Revenue> FindAllRevenueByYear(int year);

    @Query("Select r from Revenue r where YEAR(r.createdOn)= :year and MONTH(r.createdOn) = :month")
    List<Revenue> AllBySpecificMonth(int year, int month);

}
