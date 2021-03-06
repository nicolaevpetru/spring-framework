package com.mockmvc;

import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
public class UnitTestingImp {

    DataRepository dataRepository;

    public UnitTestingImp(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public int calculateSum(int[] data) {
        int sum = 0;
        return Arrays.stream(data).sum();
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        return Arrays.stream(dataRepository.findAll()).sum();
    }

    public int calculateSumUsingDataServiceWithParams() {
        int sum = 0;
        return Arrays.stream(dataRepository.findById(2)).sum();
    }
}
