/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.oceanstudy.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "os_fish", catalog = "oceanstudy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OsFish.findAll", query = "SELECT o FROM OsFish o")
    , @NamedQuery(name = "OsFish.findById", query = "SELECT o FROM OsFish o WHERE o.id = :id")
    , @NamedQuery(name = "OsFish.findByName", query = "SELECT o FROM OsFish o WHERE o.name = :name")
    , @NamedQuery(name = "OsFish.findByWeight", query = "SELECT o FROM OsFish o WHERE o.weight = :weight")
    , @NamedQuery(name = "OsFish.findByLength", query = "SELECT o FROM OsFish o WHERE o.length = :length")
    , @NamedQuery(name = "OsFish.findByHeight", query = "SELECT o FROM OsFish o WHERE o.height = :height")
    , @NamedQuery(name = "OsFish.findByDeep", query = "SELECT o FROM OsFish o WHERE o.deep = :deep")
    , @NamedQuery(name = "OsFish.findByAge", query = "SELECT o FROM OsFish o WHERE o.age = :age")
    , @NamedQuery(name = "OsFish.findByImg", query = "SELECT o FROM OsFish o WHERE o.img = :img")
    , @NamedQuery(name = "OsFish.findByVideo", query = "SELECT o FROM OsFish o WHERE o.video = :video")})
public class OsFish implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "length")
    private Integer length;
    @Column(name = "height")
    private Integer height;
    @Column(name = "deep")
    private Integer deep;
    @Column(name = "age")
    private Integer age;
    @Column(name = "img", length = 250)
    private String img;
    @Column(name = "video", length = 250)
    private String video;

    public OsFish() {
    }

    public OsFish(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getDeep() {
        return deep;
    }

    public void setDeep(Integer deep) {
        this.deep = deep;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
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
        if (!(object instanceof OsFish)) {
            return false;
        }
        OsFish other = (OsFish) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fpt.oceanstudy.entity.OsFish[ id=" + id + " ]";
    }
    
}
