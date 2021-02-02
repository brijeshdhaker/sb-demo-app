package sample.multimodule.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

@Entity
public class Account extends BaseEntity {

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
    
}
