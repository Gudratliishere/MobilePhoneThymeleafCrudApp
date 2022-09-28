package com.gudratli.mobilephone.dto;

import com.gudratli.mobilephone.entity.Mobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileDTO
{
    private Long id;
    private String price;
    private String phone;
    private Long modelId;

    public static MobileDTO of (Mobile mobile)
    {
        return new MobileDTO(mobile.getId(), mobile.getPrice(), mobile.getPhone(), mobile.getModel().getId());
    }
}
