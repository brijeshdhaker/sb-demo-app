package sample.multimodule.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import sample.multimodule.utilities.converters.LocalDateTimeConverter;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_SEQ_GENERATOR")
    @SequenceGenerator(name= "ACCOUNT_SEQ_GENERATOR", sequenceName = "ACCOUNT_SEQUENCE", schema = "PUBLIC", allocationSize = 1)
    @Column(name= "ID", updatable = false, nullable = false)
    private Long id;
    
    @Column(name= "ACC_NUMBER")
    private String number;

    @Column(name= "ACC_TYPE")
    private String type;

    @Column(name= "CC_NUMBER")
    private String creditCardNumber;

    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name= "ADD_TS")
    private LocalDateTime createTs;
    
    @Convert(converter = LocalDateTimeConverter.class)
    @Column(name= "UPDATE_TS")
    private LocalDateTime updateTs;
    
    @PrePersist
    public void prePersist(){
        createTs = updateTs = LocalDateTime.now();
    }
    
    @PreUpdate
    public void preUpdate(){
        updateTs = LocalDateTime.now();
    }
    
    /**
     * Create an empty account.
     */
    public Account() {

    }

    /**
     * Create a new account.
     *
     * @param number the account number
     * @param id the account id
     */
    public Account(Long id, String number) {
        this.number = number;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public LocalDateTime getCreateTs() {
        return createTs;
    }

    public void setCreateTs(LocalDateTime createTs) {
        this.createTs = createTs;
    }

    public LocalDateTime getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(LocalDateTime updateTs) {
        this.updateTs = updateTs;
    }
    
}
