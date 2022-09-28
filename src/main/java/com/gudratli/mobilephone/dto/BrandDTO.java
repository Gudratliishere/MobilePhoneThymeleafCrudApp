package com.gudratli.mobilephone.dto;

import com.gudratli.mobilephone.entity.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BrandDTO
{
    private Long id;
    private String name;

    public static BrandDTO of (Brand brand)
    {
        return new BrandDTO(brand.getId(), brand.getName());
    }

    public static List<BrandDTO> of (List<Brand> brands)
    {
        List<BrandDTO> brandDTOs = new ArrayList<>();

        brands.forEach(brand -> brandDTOs.add(of(brand)));

        return brandDTOs;
    }
}
