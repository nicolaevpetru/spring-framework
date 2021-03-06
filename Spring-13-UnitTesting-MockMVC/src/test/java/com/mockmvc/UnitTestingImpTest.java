package com.mockmvc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UnitTestingImpTest {

    @Mock
    DataRepository dataRepository;

    @InjectMocks
    UnitTestingImp unitTesting;

    @Test
    void calculateSum() {
        UnitTestingImp unitTesting = new UnitTestingImp();
        int actual = unitTesting.calculateSum(new int[]{1, 2, 3});
        assertEquals(6, actual);
    }

    @Test
    void calculateSumUsingDataService() {
        DataRepositoryImpl dataRepository = new DataRepositoryImpl();
        UnitTestingImp unitTesting = new UnitTestingImp(dataRepository);
        int actual = unitTesting.calculateSumUsingDataService();
        assertEquals(6, actual);
    }

    @Test
    void calculateSumUsingDataService_Mock() {
        when(dataRepository.findAll()).thenReturn(new int[]{1, 2, 3}).thenReturn(new int[]{5, 5, 5});

        int actual = unitTesting.calculateSumUsingDataService();
        int actual2 = unitTesting.calculateSumUsingDataService();
        assertEquals(6, actual);
        assertEquals(15, actual2);

    }

    @Test
    void calculateSumUsingDataService_Mock_WithParams() {

        when(dataRepository.findById(2)).thenReturn(new int[]{10, 10, 10});
        int actual = unitTesting.calculateSumUsingDataServiceWithParams();
        assertEquals(30, actual);

    }

    @Test
    void calculateSumUsingDataService_Mock_WithGenericParams() {

        when(dataRepository.findById(anyInt())).thenReturn(new int[]{10, 10, 10});
        int actual = unitTesting.calculateSumUsingDataServiceWithParams();
        assertEquals(30, actual);

    }
}