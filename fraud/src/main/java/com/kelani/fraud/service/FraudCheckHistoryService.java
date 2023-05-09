package com.kelani.fraud.service;

import com.kelani.fraud.models.FraudCheckHistory;
import com.kelani.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckHistoryService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {


    public boolean isFraudCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
         return false;
     }
}
