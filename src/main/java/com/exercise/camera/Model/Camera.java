/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exercise.camera.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author trung
 */
@Entity
@Table(name = "Camera", catalog = "StoreDB", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Camera.findAll", query = "SELECT c FROM Camera c"),
    @NamedQuery(name = "Camera.findById", query = "SELECT c FROM Camera c WHERE c.id = :id"),
    @NamedQuery(name = "Camera.findByName", query = "SELECT c FROM Camera c WHERE c.name = :name"),
    @NamedQuery(name = "Camera.findByPrice", query = "SELECT c FROM Camera c WHERE c.price = :price")})
public class Camera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotEmpty
    @Basic(optional = false)
    @Column(name = "id", nullable = false, length = 10)
    private String id;

    @NotEmpty
    @Basic(optional = false)
    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Min(value = 100)
    @Max(value = 200_000)
    @Column(name = "price")
    private Integer price;

    public Camera() {
    }

    public Camera(String id) {
        this.id = id;
    }

    public Camera(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Camera)) {
            return false;
        }
        Camera other = (Camera) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exercise.camera.Model.Camera[ id=" + id + " ]";
    }

}
