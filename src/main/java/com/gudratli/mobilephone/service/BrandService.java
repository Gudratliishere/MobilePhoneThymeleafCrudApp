package com.gudratli.mobilephone.service;

import com.gudratli.mobilephone.entity.Brand;

import java.util.List;

public interface BrandService
{
    List<Brand> getAll();

    Brand getById (Long id);

    Brand getByName (String name);

    Brand save (Brand brand);
}
