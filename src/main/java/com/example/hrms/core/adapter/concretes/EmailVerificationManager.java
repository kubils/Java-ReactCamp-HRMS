package com.example.hrms.core.adapter.concretes;

import com.example.hrms.core.adapter.abstracts.EmailVerficationService;
import org.springframework.stereotype.Service;

@Service
public class EmailVerificationManager implements EmailVerficationService {
    @Override
    public boolean isEmailActivated(String email) {
        return true;
    }
}
