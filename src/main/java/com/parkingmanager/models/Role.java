package com.parkingmanager.models;

import io.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Role")
public class Role extends Model {
    @Id
    private int IdRole;
    @NotNull
    private String Role;
}
