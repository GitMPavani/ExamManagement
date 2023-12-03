/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycode;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Pavani Madarasinghe
 */
@Entity
@Table(name = "SUBJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s")
    , @NamedQuery(name = "Subject.findBySubid", query = "SELECT s FROM Subject s WHERE s.subid = :subid")
    , @NamedQuery(name = "Subject.findBySubjectname", query = "SELECT s FROM Subject s WHERE s.subjectname = :subjectname")
    , @NamedQuery(name = "Subject.findByDepartment", query = "SELECT s FROM Subject s WHERE s.department = :department")
    , @NamedQuery(name = "Subject.findByYears", query = "SELECT s FROM Subject s WHERE s.years = :years")
    , @NamedQuery(name = "Subject.findBySemester", query = "SELECT s FROM Subject s WHERE s.semester = :semester")
    , @NamedQuery(name = "Subject.findByHall", query = "SELECT s FROM Subject s WHERE s.hall = :hall")
    , @NamedQuery(name = "Subject.findByDate", query = "SELECT s FROM Subject s WHERE s.date = :date")
    , @NamedQuery(name = "Subject.findByTimes", query = "SELECT s FROM Subject s WHERE s.times = :times")})
public class Subject implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SUBID")
    private Integer subid;
    @Column(name = "SUBJECTNAME")
    private String subjectname;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "YEARS")
    private Integer years;
    @Column(name = "SEMESTER")
    private String semester;
    @Column(name = "HALL")
    private String hall;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "TIMES")
    private String times;
    @OneToMany(mappedBy = "subid")
    private Collection<Student> studentCollection;

    public Subject() {
    }

    public Subject(Integer subid) {
        this.subid = subid;
    }

    public Integer getSubid() {
        return subid;
    }

    public void setSubid(Integer subid) {
        Integer oldSubid = this.subid;
        this.subid = subid;
        changeSupport.firePropertyChange("subid", oldSubid, subid);
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        String oldSubjectname = this.subjectname;
        this.subjectname = subjectname;
        changeSupport.firePropertyChange("subjectname", oldSubjectname, subjectname);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        String oldDepartment = this.department;
        this.department = department;
        changeSupport.firePropertyChange("department", oldDepartment, department);
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        Integer oldYears = this.years;
        this.years = years;
        changeSupport.firePropertyChange("years", oldYears, years);
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        String oldSemester = this.semester;
        this.semester = semester;
        changeSupport.firePropertyChange("semester", oldSemester, semester);
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        String oldHall = this.hall;
        this.hall = hall;
        changeSupport.firePropertyChange("hall", oldHall, hall);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        String oldTimes = this.times;
        this.times = times;
        changeSupport.firePropertyChange("times", oldTimes, times);
    }

    @XmlTransient
    public Collection<Student> getStudentCollection() {
        return studentCollection;
    }

    public void setStudentCollection(Collection<Student> studentCollection) {
        this.studentCollection = studentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subid != null ? subid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.subid == null && other.subid != null) || (this.subid != null && !this.subid.equals(other.subid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return subjectname;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    void setStudentCollection(Student st) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setSid(Student st) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
