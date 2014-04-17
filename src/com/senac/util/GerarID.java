package com.senac.util;

import static java.util.UUID.randomUUID;

public class GerarID {

    private String id;

    public GerarID() {
        setId(randomUUID().toString());
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

}
