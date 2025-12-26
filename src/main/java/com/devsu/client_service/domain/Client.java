package com.devsu.client_service.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
@PrimaryKeyJoinColumn(name = "person_id")
public class Client extends Person {

    @Column(name = "client_id", nullable = false, unique = true)
    private String clientId;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean statement;

    public Client() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatement() {
        return statement;
    }

    public void setStatement(Boolean statement) {
        this.statement = statement;
    }
}
