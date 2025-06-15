package com.store.mysqlsampledatabase.controller;

import com.store.mysqlsampledatabase.model.Office;
import com.store.mysqlsampledatabase.model.Product;
import com.store.mysqlsampledatabase.service.officeServices.OfficeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/office")
@RequiredArgsConstructor
public class OfficeController {
    private final OfficeService officeService;


    @GetMapping("/getOffice/{officeCode}")
    ResponseEntity<Office> getOffice(@PathVariable String officeCode) {
        Office office  = officeService.getOffice(officeCode);
        return ResponseEntity.ok(office);
    }

    @GetMapping("/getOffices")
    ResponseEntity<List<Office>> getOffices() {
        List<Office> offices = officeService.getAllOffice();
        return ResponseEntity.ok(offices);
    }

    @PostMapping("/saveOffice")
    ResponseEntity<Office> saveOffice(@RequestBody Office office) {
        Office savedOffice = officeService.addOffice(office);
        return ResponseEntity.ok(savedOffice);
    }

    @PatchMapping("/updateOffice/{officeCode}")
    ResponseEntity<Office> updateOffice(@PathVariable String officeCode,@RequestBody Map<String ,Object> updates) {
        Office updatedOffice = officeService.updateOfficeFields(officeCode, updates);
        return ResponseEntity.ok(updatedOffice);
    }

    @DeleteMapping("/deleteOffice/{officeCode}")
    public ResponseEntity<?> deleteOffice(@PathVariable String officeCode) {
        officeService.deleteOffice(officeCode);
        return ResponseEntity.ok().body(
                Map.of("Message", "Office deleted successfully!"));
    }

}
