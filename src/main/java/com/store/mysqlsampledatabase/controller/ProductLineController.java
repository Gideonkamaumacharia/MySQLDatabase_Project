package com.store.mysqlsampledatabase.controller;

import com.store.mysqlsampledatabase.model.Productline;
import com.store.mysqlsampledatabase.service.productLineServices.ProductLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductLineController {
    private final ProductLineService productLineService;

    @GetMapping("/productLines")
    ResponseEntity<List<Productline>> getProductLines() {
        List<Productline> productLines = productLineService.getProductLines();
        return ResponseEntity.ok(productLines);
    }
}
