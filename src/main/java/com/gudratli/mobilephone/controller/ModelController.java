package com.gudratli.mobilephone.controller;

import com.gudratli.mobilephone.dto.BrandDTO;
import com.gudratli.mobilephone.dto.ModelDTO;
import com.gudratli.mobilephone.entity.Brand;
import com.gudratli.mobilephone.service.BrandService;
import com.gudratli.mobilephone.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ModelController
{
    private final ModelService modelService;
    private final BrandService brandService;

    @GetMapping("/saveModel")
    public String add (Model model)
    {
        ModelDTO modelDTO = new ModelDTO();
        model.addAttribute("model", modelDTO);
        model.addAttribute("brands", BrandDTO.of(brandService.getAll()));
        return "save_model";
    }

    @PostMapping("/saveModel")
    public String save (@ModelAttribute("model") ModelDTO modelDTO)
    {
        com.gudratli.mobilephone.entity.Model tempModel = modelService.getByName(modelDTO.getModelName());
        if (tempModel != null && tempModel.getBrand().getId().equals(modelDTO.getBrandId()))
            return "redirect:/saveMobile";

        Brand brand = brandService.getById(modelDTO.getBrandId());
        com.gudratli.mobilephone.entity.Model model = new com.gudratli.mobilephone.entity.Model(modelDTO.getModelName(),
                brand);
        modelService.save(model);
        return "redirect:/saveMobile";
    }
}
