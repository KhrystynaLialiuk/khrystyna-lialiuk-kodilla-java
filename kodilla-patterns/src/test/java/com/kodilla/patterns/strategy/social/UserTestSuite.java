package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        Millenials ewa = new Millenials("Ewa Cicha");
        YGeneration damian = new YGeneration("Damian Koc");
        ZGeneration krystyna = new ZGeneration("Krystyna Noc");
        //When
        String ewaPost = ewa.sharePost();
        String damianPost = damian.sharePost();
        String krystynaPost = krystyna.sharePost();
        //Then
        Assert.assertEquals("I am using Facebook!", ewaPost);
        Assert.assertEquals("I am using Twitter!", damianPost);
        Assert.assertEquals("I am using Snapchat!", krystynaPost);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        Millenials ewa = new Millenials("Ewa Cicha");
        String ewaPost = ewa.sharePost();
        //When
        ewa.setSocialPublisher(new SnapchatPublisher());
        String ewaNewPost = ewa.sharePost();
        //Then
        Assert.assertEquals("I am using Facebook!", ewaPost);
        Assert.assertEquals("I am using Snapchat!", ewaNewPost);
    }
}
