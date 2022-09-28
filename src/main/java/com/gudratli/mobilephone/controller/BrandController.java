package com.gudratli.mobilephone.controller;

import com.gudratli.mobilephone.dto.BrandDTO;
import com.gudratli.mobilephone.entity.Brand;
import com.gudratli.mobilephone.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BrandController
{
    private final BrandService brandService;

    @GetMapping("/saveBrand")
    public String index (Model model)
    {
        BrandDTO brandDTO = new BrandDTO();
        model.addAttribute("brand", brandDTO);
        return "save_brand";
    }

    @PostMapping("/saveBrand")
    public String saveBrand (@ModelAttribute("brand") BrandDTO brandDTO)
    {
        if (brandService.getByName(brandDTO.getName()) != null)
            return "redirect:/saveModel";

        Brand brand = new Brand(brandDTO.getName());
        brandService.save(brand);
        return "redirect:/saveModel";
    }
}
