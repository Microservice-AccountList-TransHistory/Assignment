package com.bank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "transactions")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDetails {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "account_id")
    private Long accountNumber;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "transdate")
    private Date transDate;
    @Column(name = "currency")
    private String currency;
    @Column(name = "credit_amount")
    private String creditAmount;

    @Column(name = "debit_amount")
    private String debitAmount;
    @Column(name = "trans_type")
    private String transType;

}
