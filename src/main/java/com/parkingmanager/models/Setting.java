package com.parkingmanager.models;

import io.ebean.Model;
import io.ebean.annotation.NotNull;

import javax.persistence.*;

@Entity @Table(name = "Setting")
public class Setting extends Model {
    @Id
    private int IdSetting;
    @NotNull @OneToOne
    @JoinColumn(name = "id")
    private int id;

}
