package com.gudratli.mobilephone.service.impl;

import com.gudratli.mobilephone.entity.Brand;
import com.gudratli.mobilephone.repository.BrandRepository;
import com.gudratli.mobilephone.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService
{
    private final BrandRepository brandRepository;

    @Override
    public List<Brand> getAll ()
    {
        return brandRepository.findAll();
    }

    @Override
    public Brand getById (Long id)
    {
        return brandRepository.findById(id).orElse(null);
    }

    @Override
    public Brand getByName (String name)
    {
        return brandRepository.findByName(name);
    }

    @Override
    public Brand save (Brand brand)
    {
        return brandRepository.save(brand);
    }
}
