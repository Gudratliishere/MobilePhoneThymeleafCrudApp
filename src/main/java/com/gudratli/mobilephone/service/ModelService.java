package com.gudratli.mobilephone.service;

import com.gudratli.mobilephone.entity.Model;

import java.util.List;

public interface ModelService
{
    List<Model> getAll();

    Model getById (Long id);

    Model getByName (String name);

    Model save (Model model);
}
