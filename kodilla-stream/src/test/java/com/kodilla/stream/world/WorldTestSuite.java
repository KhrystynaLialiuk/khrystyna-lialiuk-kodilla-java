package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        // Given
        Country poland = new Country("Poland", new BigDecimal("38000000"));
        Country ukraine = new Country("Ukraine", new BigDecimal("44000000"));
        Country germany = new Country("Germany", new BigDecimal("82000000"));
        Continent eurasia = new Continent();
        eurasia.addCountry(poland);
        eurasia.addCountry(ukraine);
        eurasia.addCountry(germany);

        Country usa = new Country("USA", new BigDecimal("327200000"));
        Country canada = new Country("Canada", new BigDecimal("37260000"));
        Country mexico = new Country("Mexico", new BigDecimal("129200000"));
        Continent northAmerica = new Continent();
        northAmerica.addCountry(usa);
        northAmerica.addCountry(canada);
        northAmerica.addCountry(mexico);

        Country brazil = new Country("Brazil",new BigDecimal("209300000"));
        Country argentina = new Country("Argentina", new BigDecimal("44270000"));
        Country peru = new Country("Peru", new BigDecimal("32170000"));
        Continent southAmerica = new Continent();
        southAmerica.addCountry(brazil);
        southAmerica.addCountry(argentina);
        southAmerica.addCountry(peru);

        World world = new World();
        world.addContinent(eurasia);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);

        // When
        BigDecimal result = world.getPeopleQuantity();

        // Then
        BigDecimal expected = new BigDecimal("943400000");
        Assert.assertEquals(expected, result);
    }
}
