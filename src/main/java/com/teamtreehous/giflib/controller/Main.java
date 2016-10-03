package com.teamtreehous.giflib.controller;

/**
 * @author braendi
 */
public class Main {

    @SuppressWarnings("static-access")
    public static void main(String[] args) {

        // Store some important names in the history of computing
        String[] names = {"Babbage","Lovelace","Hopper","Gosling"};

        // Create a String
        String str = new String();

        // Join the list of names into a single string,
        // separated by commas
        String commaSeparated = str.join(",",names);
        System.out.println(commaSeparated);
    } }
