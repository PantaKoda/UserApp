package org.userapplication;

import java.util.*;
/**
 * Manages the storage and retrieval of User objects.
 * It provides functionalities to add, remove, retrieve a single user by ID,
 * retrieve all users, and retrieve all users sorted by name.
 */
public final class UserList {

    private Map<String, User> userMap;

    public UserList() {
        this.userMap = new HashMap<>();
    }


    public void addUser(User user){
        if (user != null){
            userMap.put(user.getUserId(),user);
        }
    }

    public boolean removeUser(String userId){
       return userMap.remove(userId) != null;
    }


    public User getUserById(String userId){
        User user = userMap.get(userId);
        if (user==null){
            throw new NoSuchElementException("No user found with ID: " + userId);
        }
        return user;    }



    public List<User> getAllUsers(){
        return new ArrayList<>(userMap.values());
    }

    public List<User> getUsersSortedByName(){
        List<User> sortedUsers= new ArrayList<>(userMap.values());
        //ascending order
        sortedUsers.sort(Comparator.comparing(User::getUserName));
        return sortedUsers;
    }


}
