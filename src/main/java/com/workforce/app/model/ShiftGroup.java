
package com.workforce.app.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author david
 */
@Entity
@Table(name = "shift_group")
@NamedQueries({
    @NamedQuery(name = "ShiftGroup.findAll", query = "SELECT s FROM ShiftGroup s")})
public class ShiftGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "code")
    private String code;
    @ManyToMany(mappedBy = "shiftGroupSet")
    private Set<Shift> shiftSet;

    public ShiftGroup() {
    }

    public ShiftGroup(Integer id) {
        this.id = id;
    }

    public ShiftGroup(String code) {
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

    public Set<Shift> getShiftSet() {
        if (this.shiftSet == null) {
            shiftSet = new HashSet<>();
        }
        return shiftSet;
    }

    public void setShiftSet(Set<Shift> shiftSet) {
        this.shiftSet = shiftSet;
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
        if (!(object instanceof ShiftGroup)) {
            return false;
        }
        ShiftGroup other = (ShiftGroup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.workforce.demo.model.ShiftGroup[ id=" + id + " ]";
    }

}
