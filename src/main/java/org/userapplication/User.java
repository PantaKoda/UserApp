package org.userapplication;

/**
 * Represents a user with unique identification and personal details.
 * This class follows the Builder Pattern to facilitate the construction of User objects.
 */

public final class User {

    private final String userId;
    private final String userName;
    private final String userEmail;
    private String userRegistrationDate;
    private String userGender;
    private String userCountry;

    private User(Builder builder) {
        userId = builder.userId;
        userName = builder.userName;
        userEmail = builder.userEmail;
        userRegistrationDate = builder.userRegistrationDate;
        userGender = builder.userGender;
        userCountry = builder.userCountry;
    }


    public static final class Builder {
        private final String userId;
        private final String userName;
        private final String userEmail;
        private String userRegistrationDate;
        private String userGender;
        private String userCountry;

        //Mandatory fields
        public Builder(String userId, String userName, String userEmail) {
            this.userId = userId;
            this.userName = userName;
            this.userEmail = userEmail;
        }

        //Optional fields
        public Builder userRegistrationDate(String val) {
            userRegistrationDate = val;
            return this;
        }

        public Builder userGender(String val) {
            userGender = val;
            return this;
        }

        public Builder userCountry(String val) {
            userCountry = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserCountry() {
        return userCountry;
    }
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userRegistrationDate='" + userRegistrationDate + '\'' +
                ", userGender='" + userGender + '\'' +
                ", userCountry='" + userCountry + '\'' +
                '}';
    }

}
