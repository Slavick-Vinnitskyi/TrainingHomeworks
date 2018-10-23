package com.homeworks.block4.controller;

public interface RegexContainer {
    // Cyrillic name
    String REGEX_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    // Latin name
    String REGEX_NAME_LAT = "^[A-Z][a-z]{1,20}$";
    // login
    String REGEX_LOGIN = "^[A-Za-z0-9_-]{8,20}$";
    //regex for telephone
    String REGEX_PHONE = "^(\\+38)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
}
