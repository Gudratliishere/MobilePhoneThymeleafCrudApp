package com.gudratli.mobilephone.service;

import com.gudratli.mobilephone.entity.Mobile;

import java.util.List;

public interface MobileService
{
    List<Mobile> getAll ();

    Mobile getById (Long id);

    Mobile save (Mobile mobile);
}
