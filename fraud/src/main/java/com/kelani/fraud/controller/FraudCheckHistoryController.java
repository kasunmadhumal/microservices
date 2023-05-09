package com.kelani.fraud.controller;

import com.kelani.fraud.models.FraudCheckResponse;
import com.kelani.fraud.service.FraudCheckHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/fraud-check/")
public record FraudCheckHistoryController(FraudCheckHistoryService fraudCheckHistoryService) {

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
            Boolean response =  fraudCheckHistoryService.isFraudCustomer(customerId);
            return new FraudCheckResponse(response);
    }

}
