package com.odeal.service;

import com.odeal.dto.request.CreatePaymentTypeRequestDto;
import com.odeal.dto.request.UpdatePaymentTypeRequestDto;
import com.odeal.mapper.PaymentTypeMapper;
import com.odeal.repository.IPaymentTypeRepository;
import com.odeal.repository.entity.PaymentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentTypeService {

    private final IPaymentTypeRepository repository;
    private final PaymentTypeMapper mapper;

    public PaymentType savePaymentType(CreatePaymentTypeRequestDto dto){
        return repository.save(mapper.fromCreate(dto));
    }

    public PaymentType findPaymentTypeById(long id){
        Optional<PaymentType> paymentTypeDb = repository.findById(id);
        if(paymentTypeDb.isEmpty()){
            throw new EntityNotFoundException("Unable to find item by given id:" + id);
        }
        return paymentTypeDb.get();
    }

    public List<PaymentType> listAllPaymentTypes(){
        return repository.findAll();
    }

    public PaymentType updatePaymentType(UpdatePaymentTypeRequestDto dto){
        PaymentType paymentType = findPaymentTypeById(dto.getId());
        paymentType = mapper.fromUpdate(dto);
        return repository.save(paymentType);
    }

    public String deletePaymentType(long id){
        PaymentType paymentType = findPaymentTypeById(id);
        repository.delete(paymentType);
        return "Selected item has been deleted successfully";

    }


}
