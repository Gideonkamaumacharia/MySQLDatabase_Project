package com.store.mysqlsampledatabase.service.officeServices;

import com.store.mysqlsampledatabase.model.Office;

import java.util.List;
import java.util.Map;

public interface OfficeService {
    List<Office> getAllOffice();
    Office getOffice(String officeCode);
    Office addOffice(Office office);
    Office updateOfficeFields(String officeCode, Map<String, Object> updates);

    void deleteOffice(String officeCode);
}
