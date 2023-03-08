package com.bank.application;

import com.bank.entity.AccountDetails;
import com.bank.entity.TransactionDetails;
import com.bank.exception.CustomException;
import com.bank.repository.AccountDetailsRepository;
import com.bank.repository.TransactionDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    @Autowired
    private AccountDetailsRepository accountDetailsRepository;
    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    public List<AccountDetails> getAccountDetailsList(Long id, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        List<AccountDetails> accountDetailsList = accountDetailsRepository.findByCustomerId(id, paging);
        if (accountDetailsList.isEmpty()) {
            throw new CustomException("Customer Id not Found");
        }
        return accountDetailsList;
    }

    public List<TransactionDetails> getTransactionDetailsList(Integer pageNo, Integer pageSize, String sortBy, Long id) {

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        List<TransactionDetails> transactionDetailsList = transactionDetailsRepository.findByAccountNumber(id, paging);
        if (transactionDetailsList.isEmpty()) {
            throw new CustomException("Account Id not Found");
        }
        return transactionDetailsList;
    }

}
