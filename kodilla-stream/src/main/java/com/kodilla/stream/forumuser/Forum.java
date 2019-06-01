package com.kodilla.stream.forumuser;

import java.util.ArrayList;
import java.util.List;

public final class Forum {
    private final List<ForumUser> theForumUserList = new ArrayList<>();

    public Forum(){
        theForumUserList.add(new ForumUser(100, "Khrystyna", 'F',
                1994, 3, 25, 3));
        theForumUserList.add(new ForumUser(101, "Pawel", 'M',
                1994, 12, 23, 0));
        theForumUserList.add(new ForumUser(102, "MariuszD", 'M',
                1990, 1, 2, 10));
        theForumUserList.add(new ForumUser(103, "DariuszK", 'M',
                1980, 7, 18, 20));
        theForumUserList.add(new ForumUser(104, "JakubSobczak", 'M',
                2000, 12, 3, 15));
        theForumUserList.add(new ForumUser(105, "Nikolas", 'M',
                1999, 6, 1, 10));
    }

    public List<ForumUser> getUserList(){
        return new ArrayList<>(theForumUserList);
    }
}
