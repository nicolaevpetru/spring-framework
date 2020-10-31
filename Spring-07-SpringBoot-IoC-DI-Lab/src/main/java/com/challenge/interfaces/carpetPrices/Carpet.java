package com.challenge.interfaces.carpetPrices;


import com.challenge.enums.City;

import java.math.BigDecimal;

public interface Carpet {
    BigDecimal getSqFtPrice(City city);
}
