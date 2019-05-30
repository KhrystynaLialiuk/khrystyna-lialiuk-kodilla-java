package com.kodilla.testing.forum.statistics;

public class StatisticsCalculation {

    private int amountOfUsers;
    private int amountOfPosts;
    private int amountOfComments;
    private double amountOfPostsPerUser;
    private double amountOfCommentsPerUser;
    private double amountOfCommentsPerPost;

    public void calculateAdvStatistics (Statistics statistics){
        amountOfUsers = statistics.userNames().size();
        amountOfPosts = statistics.postsCount();
        amountOfComments = statistics.commentsCount();

        if (amountOfPosts > 0 && amountOfUsers > 0) {
            if (amountOfUsers > amountOfPosts){
                double doubleAmountOfUsers = (double) amountOfUsers;
                amountOfPostsPerUser = amountOfPosts / doubleAmountOfUsers;
            } else {
                amountOfPostsPerUser = amountOfPosts / amountOfUsers;
            }
        }

        if (amountOfComments > 0 && amountOfUsers > 0) {
            if (amountOfUsers > amountOfComments){
                double doubleAmountOfUsers = (double) amountOfUsers;
                amountOfCommentsPerUser = amountOfComments / doubleAmountOfUsers;
            } else {
                amountOfCommentsPerUser = amountOfComments / amountOfUsers;
            }
        }

        if (amountOfComments > 0 && amountOfPosts > 0){
            if (amountOfPosts > amountOfComments){
                double doubleAmountOfPosts = (double) amountOfPosts;
                amountOfCommentsPerPost = amountOfComments / doubleAmountOfPosts;
            } else {
                amountOfCommentsPerPost = amountOfComments / amountOfPosts;
            }
        }
    }

    public void showStatistics(){
        System.out.println(amountOfUsers + " - amount of Users");
        System.out.println(amountOfPosts + " - amount of Posts");
        System.out.println(amountOfComments + " - amount of Comments");
        System.out.println(amountOfPostsPerUser + " - amount of posts per user");
        System.out.println(amountOfCommentsPerUser + " - amount of comments per user");
        System.out.println(amountOfCommentsPerPost + " - amount of comments per post");
    }

    public int getAmountOfUsers() {
        return amountOfUsers;
    }

    public int getAmountOfPosts() {
        return amountOfPosts;
    }

    public int getAmountOfComments() {
        return amountOfComments;
    }

    public double getAmountOfPostsPerUser() {
        return amountOfPostsPerUser;
    }

    public double getAmountOfCommentsPerUser() {
        return amountOfCommentsPerUser;
    }

    public double getAmountOfCommentsPerPost() {
        return amountOfCommentsPerPost;
    }
}