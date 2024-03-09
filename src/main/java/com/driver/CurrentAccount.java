package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(balance < 5000){
            throw new Exception ("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        for(int i = 0; i < tradeLicenseId.length() - 1; i++){
            char ch1 = tradeLicenseId.charAt(i);
            char ch2 = tradeLicenseId.charAt(i + 1);
            if(ch1 == ch2){
                // Check if rearranging characters can form a valid license ID
                char[] sortedChars = tradeLicenseId.toCharArray();
                Arrays.sort(sortedChars);
                for (int j = 0; j < sortedChars.length - 1; j++) {
                    if (sortedChars[j] == sortedChars[j + 1]) {
                        throw new Exception("Valid License cannot be generated");
                    }
                }
            }
        }


    }
}