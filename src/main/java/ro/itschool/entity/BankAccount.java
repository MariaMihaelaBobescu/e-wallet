package ro.itschool.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import ro.itschool.enums.Currency;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
public class BankAccount implements Serializable {

    @Serial
    private static final long serialVersionUID = 1905122041950251207L;
    //UUID (Universally Unique Identifier), also known as GUID (Globally Unique Identifier) represents
// a 128-bit long value that is unique for all practical purposes.
// The standard representation of the UUID uses hex digits (octets):
    @Id
    @GeneratedValue
    private UUID id = UUID.randomUUID();

    private Currency currency;

    private Double amount;

    private Boolean isCredit;

    private String iban;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private MyUser user;

    public BankAccount() {
        this.iban = Iban.random(CountryCode.RO).toString();
        this.createdAt = LocalDateTime.now();
        this.amount = 0D;
    }

}