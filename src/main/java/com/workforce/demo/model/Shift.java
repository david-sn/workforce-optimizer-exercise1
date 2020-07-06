/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workforce.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
@Entity
@Table(name = "shift")
@NamedQueries({
    @NamedQuery(name = "Shift.findAll", query = "SELECT s FROM Shift s")})
public class Shift implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "code")
    private String code;
    @JoinTable(name = "shift_grouping", joinColumns = {
        @JoinColumn(name = "shift_code_id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "shift_group_id", referencedColumnName = "id")})
    @ManyToMany
    private Set<ShiftGroup> shiftGroupSet;

    public Shift() {
    }

    public Shift(Integer id) {
        this.id = id;
    }

    public Shift(String code) {
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Set<ShiftGroup> getShiftGroupSet() {
        if (this.shiftGroupSet == null) {
            shiftGroupSet = new HashSet<>();
        }
        return shiftGroupSet;
    }

    public void setShiftGroupSet(Set<ShiftGroup> shiftGroupSet) {
        this.shiftGroupSet = shiftGroupSet;
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
        if (!(object instanceof Shift)) {
            return false;
        }
        Shift other = (Shift) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.workforce.demo.model.Shift[ id=" + id + " ]";
    }

}
