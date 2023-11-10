package org.userapplication;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


/**
 * Defines the contract for user-related operations.
 * This interface abstracts the functionalities of creating, removing,
 * and retrieving users, including getting all users or users sorted by name.
 */
interface IUserService {
    User createUser(String userId,
                    String userName,
                    String userEmail,
                    String userRegistrationDate,
                    String userGender,
                    String userCountry);

    boolean removeUser(String userId);
    User getUserById(String userId);
    List<User> getAllUsers();
    List<User> getUsersSortedByName();
}

/**
 * Implements IUserService interface to provide user management functionalities.
 * It interacts with the UserList class to perform operations like adding, removing,
 * and retrieving users.
 */
class UserService implements IUserService {
    private UserList userList;

    public UserService() {
        this.userList = new UserList();
    }


    @Override
    public User createUser(String userId,
                           String userName,
                           String userEmail,
                           String userRegistrationDate,
                           String userGender,
                           String userCountry) {
        User.Builder builder = new User.Builder(userId, userName, userEmail);
        if (!userRegistrationDate.isEmpty()) builder.userRegistrationDate(userRegistrationDate);
        if (!userGender.isEmpty()) builder.userGender(userGender);
        if (!userCountry.isEmpty()) builder.userCountry(userCountry);
        User newUser = builder.build();
        userList.addUser(newUser);
        return newUser;
    }

    @Override
    public boolean removeUser(String userId){
        boolean removed = userList.removeUser(userId);
        if (!removed){
            System.out.println("User not found with ID: " + userId);
        }
        else {
            System.out.println("User removed successfully.");
        }
        return removed;
    }

    @Override
    public User getUserById(String userId) {

        User user = userList.getUserById(userId);
        if (user==null){
            throw new NoSuchElementException("No user found with ID: " + userId);
        }
        return user;
    }

    @Override
    public List<User> getAllUsers(){
        List<User> users = userList.getAllUsers();
        if (users.isEmpty()){
            System.out.println("No users available");
        }
        return users;
    }

    @Override
    public  List<User> getUsersSortedByName(){
        return userList.getUsersSortedByName();
    }


}

/**
 * Handles user input and output for the user management console application.
 * It interacts with the IUserService to execute user commands and displays results.
 */
class UserInterface {
    private IUserService userService;
    private Scanner scanner;

    public UserInterface(IUserService userService) {
        this.userService = userService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean quit = false;
        while (!quit) {
            showMenu();
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    removeUserById();
                    break;
                case 3:
                    showUserById();
                    break;
                case 4:
                    showAllUsers();
                    break;
                case 5:
                    showAllUsersSortedByName();
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again");
            }

        }

    }

    private void showMenu() {
        System.out.println("\nAvailable choices:");
        System.out.println("1. Create a new user");
        System.out.println("2. Remove a user by ID");
        System.out.println("3. Show a user by ID");
        System.out.println("4. show all users");
        System.out.println("5. show all users sorted by name");
        System.out.println("0. Exit");

    }

    private void createUser() {

        System.out.println("Enter a user ID:");
        String userId = scanner.nextLine();

        System.out.println("Enter username:");
        String userName = scanner.nextLine();

        System.out.println("Enter email:");
        String userEmail = scanner.nextLine();

        System.out.println("Enter registration date(Optional)");
        String userRegistrationDate = scanner.nextLine();

        System.out.println("Enter gender(Optional)");
        String userGender = scanner.nextLine();

        System.out.println("Enter country(Optional)");
        String userCountry = scanner.nextLine();

        userService.createUser(userId,
                userName,
                userEmail,
                userRegistrationDate,
                userGender,
                userCountry);

    }

    private void removeUserById(){
        System.out.println("Enter id of the user to remove:");
        String userId = scanner.nextLine();
        try {
            boolean isRemoved = userService.removeUser(userId);
            if (isRemoved){
                System.out.println("User removed successfully.");
            }
            else {
                System.out.println("User not found.");
            }
        }catch (Exception e){
            System.out.println("Error when removinf user: " + e.getMessage());
        }
    }


    private void showAllUsers(){
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()){
            System.out.println("No users available.");
        }
        else {
            for (User user: users) {
                System.out.println(user);
            }
        }
    }

    private void showUserById(){
        System.out.println("Enter the ID of the user to display:");
        String userId = scanner.nextLine();
        try {
            User user = userService.getUserById(userId);
            System.out.println(user);
        }
        catch (NoSuchElementException e){
            System.out.println("User not found: " + e.getMessage());
        }
    }

    private void showAllUsersSortedByName(){
        List<User> sortedUsers = userService.getUsersSortedByName();
        if (sortedUsers.isEmpty()){
            System.out.println("No Users available.");
        }
        else {
            for (User user: sortedUsers) {
                System.out.println(user);
            }
        }
    }

}

/**
 * The entry point of the user management console application.
 * This class initializes the application and starts the user interface.
 */
public class Main {

    public static void main(String[] args) {

    IUserService userService = new UserService();
    UserInterface userInterface = new UserInterface(userService);
    userInterface.start();
    }
}