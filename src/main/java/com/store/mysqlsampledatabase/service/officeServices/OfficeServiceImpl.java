package com.store.mysqlsampledatabase.service.officeServices;

import com.store.mysqlsampledatabase.model.Office;
import com.store.mysqlsampledatabase.model.Product;
import com.store.mysqlsampledatabase.model.ResourceNotFoundException;
import com.store.mysqlsampledatabase.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class OfficeServiceImpl implements OfficeService {

    private final OfficeRepository officeRepository;

    @Override
    public List<Office> getAllOffice() {
       return officeRepository.findAll();
    }

    @Override
    public Office getOffice(String officeCode) {
        return officeRepository.findById(officeCode)
        .orElseThrow(() -> new RuntimeException("Product not found with ID: " + officeCode));
    }

    public static String generateNumericId(int min, int max) {
        int id = new Random().nextInt((max - min) + 1) + min;
        return String.valueOf(id);
    }

    @Override
    public Office addOffice(Office office) {
        if(office.getOfficeCode() == null || office.getOfficeCode().isBlank()) {
            String officeCode = generateNumericId(8, 9999);
            office.setOfficeCode(officeCode);
        }
        return officeRepository.save(office);
    }


    @Override
    public Office updateOfficeFields(String officeCode, Map<String, Object> updates) {
        Office office = officeRepository.findById(officeCode)
                .orElseThrow(() -> new ResourceNotFoundException("Office not found with code: " + officeCode));

        updates.forEach((field, value) -> {
            switch (field) {
                case "phone":
                    office.setPhone((String) value);
                    break;
                case "addressLine1":
                    office.setAddressLine1((String) value);
                    break;
                case "addressLine2":
                    office.setAddressLine2((String) value);
                    break;
                case "city":
                    office.setCity((String) value);
                    break;
                case "state":
                    office.setState((String) value);
                    break;
                case "country":
                    office.setCountry((String) value);
                    break;
                case "postalCode":
                    office.setPostalCode((String) value);
                    break;
                case "territory":
                    office.setTerritory((String) value);
                    break;
            }
        });

        return officeRepository.save(office);
    }


    @Override
    public void deleteOffice(String officeCode) {
        Office office = officeRepository.findById(officeCode)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + officeCode));
        officeRepository.delete(office);

    }
}
