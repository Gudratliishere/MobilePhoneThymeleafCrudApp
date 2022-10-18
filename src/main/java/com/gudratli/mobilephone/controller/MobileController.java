package com.gudratli.mobilephone.controller;

import com.gudratli.mobilephone.dto.MobileDTO;
import com.gudratli.mobilephone.dto.ModelDTO;
import com.gudratli.mobilephone.entity.Mobile;
import com.gudratli.mobilephone.service.MobileService;
import com.gudratli.mobilephone.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MobileController
{
    private final MobileService mobileService;
    private final ModelService modelService;

    @GetMapping({"/", "index"})
    public String index (Model model)
    {
        return getByPaginated(1, model);
    }

    @GetMapping("/saveMobile")
    public String add (Model model)
    {
        MobileDTO mobile = new MobileDTO();
        model.addAttribute("mobile", mobile);
        model.addAttribute("models", ModelDTO.of(modelService.getAll()));
        return "save_mobile";
    }

    @GetMapping("/saveMobile/{id}")
    public String add (Model model, @PathVariable("id") Long id)
    {
        MobileDTO mobile = MobileDTO.of(mobileService.getById(id));
        model.addAttribute("mobile", mobile);
        model.addAttribute("models", ModelDTO.of(modelService.getAll()));
        return "save_mobile";
    }

    @PostMapping("/saveMobile")
    public String save (@ModelAttribute("mobile") MobileDTO mobileDTO)
    {
        Mobile mobile = new Mobile(mobileDTO.getPrice(), mobileDTO.getPhone(),
                modelService.getById(mobileDTO.getModelId()));
        mobile.setId(mobileDTO.getId());
        mobileService.save(mobile);
        return "redirect:/";
    }

    @GetMapping("/deleteMobile/{id}")
    public String delete (@PathVariable Long id)
    {
        mobileService.delete(id);

        return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String getByPaginated (@PathVariable int pageNo, Model model)
    {
        int pageSize = 5;
        Page<Mobile> page = mobileService.getWithPagination(pageNo, pageSize);
        List<Mobile> mobiles = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("mobiles", mobiles);

        return "index";
    }
}
