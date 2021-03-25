package com.parkingmanager.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import javafx.scene.control.Button;

public class dashboardController {

    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;

    public void testfunction(){
        String password = "1234";
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        // $2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6

        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
        // result.verified == true
    }
}
