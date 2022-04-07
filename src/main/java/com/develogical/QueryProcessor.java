package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.toLowerCase().contains("what is your name")) {
            return "Something!";
        } else if (query.toLowerCase().contains("which of the following numbers is the largest:")){
            return findTheLargest(query);
        } else if (query.toLowerCase().contains("plus")) {
            return doSum(query);
        }
        return "";
    }


    public String findTheLargest(String line){
        //We split the line at each space, so we can separate each number
        String[] array = line.split("\\s+");

        //Integer.MIN_VALUE will give you the smallest number an integer can have,
        //and you can use this to check against.
        int largestInt = Integer.MIN_VALUE;

        //We iterate over each of the separated numbers (they are still Strings)
        for (String numberAsString : array) {

            //Integer.parseInt will parse a number to integer from a String
            //You will get a NumberFormatException if the String can not be parsed
            int number = 0;
            try {
                number = Integer.parseInt(numberAsString);
            }catch (NumberFormatException ex) {

            }

            //Check if the parsed number is greater than the largestInt variable
            //If it is, set the largestInt variable to the number parsed
            if (number > largestInt) {
                largestInt = number;
            }
        }
        return String.valueOf(largestInt);
    }

    public String doSum(String line){
        //We split the line at each space, so we can separate each number
        String[] array = line.split("\\s+");

        //Integer.MIN_VALUE will give you the smallest number an integer can have,
        //and you can use this to check against.
        int total = 0;

        //We iterate over each of the separated numbers (they are still Strings)
        for (String numberAsString : array) {

            //Integer.parseInt will parse a number to integer from a String
            //You will get a NumberFormatException if the String can not be parsed
            int number = 0;
            try {
                number = Integer.parseInt(numberAsString);
            }catch (NumberFormatException ex) {

            }

            //Check if the parsed number is greater than the largestInt variable
            //If it is, set the largestInt variable to the number parsed
            total += number;
        }
        return String.valueOf(total);
    }
}
