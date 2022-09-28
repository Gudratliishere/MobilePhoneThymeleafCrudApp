package com.gudratli.mobilephone.dto;

import com.gudratli.mobilephone.entity.Brand;
import com.gudratli.mobilephone.entity.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelDTO
{
    private Long id;
    private String modelName;
    private String brandName;
    private Long brandId;

    public static ModelDTO of (Model model)
    {
        return new ModelDTO(model.getId(), model.getName(), model.getBrand().getName(),
                model.getBrand().getId());
    }

    public static List<ModelDTO> of (List<Model> models)
    {
        List<ModelDTO> modelDTOS = new ArrayList<>();

        models.forEach(model -> modelDTOS.add(ModelDTO.of(model)));

        return modelDTOS;
    }
}
