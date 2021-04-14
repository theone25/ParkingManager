package com.parkingmanager;

import java.io.IOException;
import io.ebean.annotation.Platform;
import io.ebean.dbmigration.DbMigration;

public class GenerateDbMigration {

    public static void main(String[] args) throws IOException {


        DbMigration dbMigration = DbMigration.create();
        dbMigration.setPlatform(Platform.MYSQL);

        dbMigration.generateMigration();
    }
}
