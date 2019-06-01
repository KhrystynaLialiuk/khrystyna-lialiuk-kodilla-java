package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String userName;
    private final char userSex;
    private final LocalDate userDateOfBirth;
    private final int amountOfPosts;

    public ForumUser(final int userId, final String userName, final char userSex, final int userYearOfBirth,
                     final int userMonthOfBirth, final int userDayOfBirth, final int amountOfPosts) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userDateOfBirth = LocalDate.of(userYearOfBirth, userMonthOfBirth, userDayOfBirth);
        this.amountOfPosts = amountOfPosts;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserSex() {
        return userSex;
    }

    public LocalDate getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public int getAmountOfPosts() {
        return amountOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex=" + userSex +
                ", userDateOfBirth=" + userDateOfBirth +
                ", amountOfPosts=" + amountOfPosts +
                '}';
    }
}
