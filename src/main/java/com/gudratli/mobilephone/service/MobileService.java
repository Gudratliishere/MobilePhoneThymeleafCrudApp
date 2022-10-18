package com.gudratli.mobilephone.service;

import com.gudratli.mobilephone.entity.Mobile;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MobileService
{
    List<Mobile> getAll ();

    Mobile getById (Long id);

    Mobile save (Mobile mobile);

    void delete (Long id);

    Page<Mobile> getWithPagination (int pageNo, int pageSize);
}
