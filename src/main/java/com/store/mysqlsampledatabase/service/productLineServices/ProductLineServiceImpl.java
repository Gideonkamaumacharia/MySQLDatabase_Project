package com.store.mysqlsampledatabase.service.productLineServices;

import com.store.mysqlsampledatabase.model.Productline;
import com.store.mysqlsampledatabase.repository.ProductLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductLineServiceImpl implements ProductLineService{
    private final ProductLineRepository productLineRepository;

    @Override
    public List<Productline> getProductLines() {
        return productLineRepository.findAll();
    }
}
