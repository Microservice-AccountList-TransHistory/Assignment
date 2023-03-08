package com.bank.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
public class AccountDetails {
    @Column(name = "customer_id")
    private Long customerId;
    @Id
    @Column(name = "account_id")
    private Long accountNumber;
    @Column(name = "account_type")
    private String accountType;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "balance_date")
    private Date balanceDate;
    @Column(name = "currency")
    private String currency;
    @Column(name = "balance")
    private String balance;

}
