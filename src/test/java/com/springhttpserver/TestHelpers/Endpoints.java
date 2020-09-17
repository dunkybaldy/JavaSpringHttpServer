package com.springhttpserver.TestHelpers;

import java.text.MessageFormat;

public class Endpoints {

    public static String BaseUrl(String www) {
        return MessageFormat.format("http://{0}/", www);
    }
    public static String BaseUrlLocalhost(int port) { return MessageFormat.format("http://localhost:{0,number,#}/", port); }
    public static String BaseUrlSecure(String www) {
        return MessageFormat.format("https://{0}/", www);
    }

    // UserProfileController
    public static String UPCGetUserProfile(String userId) {
        return MessageFormat.format("user/get/{0}", userId);
    }
    public static String UPCCreateUserProfile() {
        return "user/create";
    }
    public static String UPCUpdateUserProfile(String userId) { return MessageFormat.format("user/update/{0}", userId); }
    public static String UPCDeleteUserProfile(String userId) { return MessageFormat.format("user/delete/{0}", userId); }
}
