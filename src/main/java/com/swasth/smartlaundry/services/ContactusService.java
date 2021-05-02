package com.swasth.smartlaundry.services;

import javax.transaction.Transactional;

import com.swasth.smartlaundry.entity.ContactUs;
import com.swasth.smartlaundry.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ContactusService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    public String updateContactusInfo(ContactUs contactUs) {
        try {
            contactUsRepository.save(contactUs);
            return "OK";
        } catch (Exception e) {
            return "KO";
        }
    }

}
