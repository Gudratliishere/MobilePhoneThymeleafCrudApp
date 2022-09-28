package com.gudratli.mobilephone.service.impl;

import com.gudratli.mobilephone.entity.Model;
import com.gudratli.mobilephone.repository.ModelRepository;
import com.gudratli.mobilephone.service.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService
{
    private final ModelRepository modelRepository;

    @Override
    public List<Model> getAll ()
    {
        return modelRepository.findAll();
    }

    @Override
    public Model getById (Long id)
    {
        return modelRepository.findById(id).orElse(null);
    }

    @Override
    public Model getByName (String name)
    {
        return modelRepository.findByName(name);
    }

    @Override
    public Model save (Model model)
    {
        return modelRepository.save(model);
    }
}
