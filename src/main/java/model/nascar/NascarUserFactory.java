package model.nascar;

import org.apache.commons.lang3.RandomStringUtils;

public class NascarUserFactory {

   public static UserNascar getNewUser(){
       String email = String.format("%s@gmail.com", RandomStringUtils.random(10, true, true));
       String password = RandomStringUtils.random(10, true, true);
       String zip = RandomStringUtils.random(10, false, true);
       return new UserNascar(email, password, zip);
   }
}
