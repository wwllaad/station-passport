package com.sevgmo.stationpassport.model;

import java.util.Objects;

public abstract class AbstractEntity {
    protected int id;

    public AbstractEntity(int id) {
        this.id = id;
    }

    public AbstractEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id=" + id +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }
}
