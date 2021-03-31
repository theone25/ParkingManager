package com.parkingmanager.services;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.parkingmanager.models.Utilisateur;
import com.parkingmanager.utils.Validator;

import java.sql.SQLException;
import java.util.HashMap;

public class AuthManager {
    private static AuthManager auth;

    private Utilisateur user;
    private final HashMap<String, String> errors = new HashMap<String, String>();

    private AuthManager() {
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    synchronized public static AuthManager getDefaultInstance()
    {
        if (auth == null)
        {
            // if instance is null, initialize
            auth = new AuthManager();
        }
        return auth;
    }

    public void authenticate(String email, String password) throws SQLException {
        // check email and password are empty
        if (Validator.isEmpty(email, "email", this.errors)) {
            return;
        }
        if (Validator.isEmpty(password, "password", this.errors)) {
            return;
        }


        //check if it's not a  valid email
        if (!Validator.isEmail(email)) {
            errors.put("email", "This not a valid email");
            return;
        }
        //check if the user with this email exists
        Utilisateur existedUser = Utilisateur.getUserByEmail(email);

        if (existedUser == null) {
            errors.put("email", "invalid email or password");
            return;
        }

        //compare password with hashed password in db

        //String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        // $2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), existedUser.getPassword());
        // result.verified == true
        if (!result.verified) {
            errors.put("password", "password not valid");
            return;
        }


        //clear errors
        errors.clear();
        // set the user object
        user = existedUser;


    }
}
