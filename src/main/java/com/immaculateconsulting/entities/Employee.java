package com.immaculateconsulting.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Unogwudan
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT s FROM Employee s")
    , @NamedQuery(name = "Employee.findById", query = "SELECT s FROM Employee s WHERE s.id = :id")
    , @NamedQuery(name = "Employee.findByFirstName", query = "SELECT s FROM Employee s WHERE s.firstName = :firstName")
    , @NamedQuery(name = "Employee.findByLastName", query = "SELECT s FROM Employee s WHERE s.lastName = :lastName")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT s FROM Employee s WHERE s.email = :email")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT s FROM Employee s WHERE s.password = :password")  
    , @NamedQuery(name = "Employee.findByPhone", query = "SELECT s FROM Employee s WHERE s.phone = :phone") 
    , @NamedQuery(name = "Employee.findByAddress", query = "SELECT s FROM Employee s WHERE s.address = :address") 
    , @NamedQuery(name = "Employee.findByDateAdded", query = "SELECT s FROM Employee s WHERE s.dateAdded = :dateAdded")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "first_name")
    private String firstName;
    @Size(min = 1, max = 45)
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "last_name")
    private String lastName;
    @Size(min = 1, max = 45)
    @Column(name = "email")
    private String email;
    @Size(min = 6, max = 45)
    @Column(name = "password")
    private String password;
    @Size(min = 1, max = 15)
    @Column(name = "phone")
    private String phone;
    @Size(min = 1, max = 120)
    @Column(name = "address")
    private String address;
    @Column(name = "position")
    private String position;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "salary")
    private Double salary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitHead")
    private List<Division> divisionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private List<TeamMembers> teamMembersList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hod")
    private List<Department> departmentList;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String firstName, String lastName, Date dateAdded) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateAdded = dateAdded;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
    
    
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    
    @JsonbTransient
    @XmlTransient
    public List<Division> getDivisionList() {
        return divisionList;
    }

    public void setDivisionList(List<Division> divisionList) {
        this.divisionList = divisionList;
    }

    @JsonbTransient
    @XmlTransient
    public List<TeamMembers> getTeamMembersList() {
        return teamMembersList;
    }

    public void setTeamMembersList(List<TeamMembers> teamMembersList) {
        this.teamMembersList = teamMembersList;
    }

    @JsonbTransient
    @XmlTransient
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.immaculateconsultingstaffmanagement.Staff[ id=" + id + " ]";
    }
    
}
