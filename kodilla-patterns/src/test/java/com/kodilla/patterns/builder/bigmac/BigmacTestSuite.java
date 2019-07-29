package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Sesame")
                .burgers(2)
                .sauce("Standard")
                .ingredient("Shrimps")
                .ingredient("Lettuce")
                .build();
        System.out.println(bigmac);
        //When
        String chosenBun = bigmac.getBun();
        int amountOfBurgers = bigmac.getBurgers();
        String chosenSauce = bigmac.getSauce();
        int amountOfIngredients = bigmac.getIngredients().size();

        //Then
        Assert.assertEquals("Sesame", chosenBun);
        Assert.assertEquals(2, amountOfBurgers);
        Assert.assertEquals("Standard", chosenSauce);
        Assert.assertEquals(2, amountOfIngredients);
    }

    @Test
    public void testBigmacBuilderWithException() {
        //Given
        boolean thrown = false;
        //When
        try {
            Bigmac bigmac = new Bigmac.BigmacBuilder()
                    .bun("Sesame")
                    .burgers(2)
                    .sauce("Standard")
                    .ingredient("Shrimps")
                    .ingredient("Ham")
                    .build();
            System.out.println(bigmac);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        //Then
        Assert.assertTrue(thrown);
    }
}
