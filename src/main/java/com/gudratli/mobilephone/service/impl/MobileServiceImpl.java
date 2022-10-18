package com.gudratli.mobilephone.service.impl;

import com.gudratli.mobilephone.entity.Mobile;
import com.gudratli.mobilephone.repository.MobileRepository;
import com.gudratli.mobilephone.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MobileServiceImpl implements MobileService
{
    private final MobileRepository mobileRepository;

    @Override
    public List<Mobile> getAll ()
    {
        return mobileRepository.findAll();
    }

    @Override
    public Mobile getById (Long id)
    {
        return mobileRepository.findById(id).orElse(null);
    }

    @Override
    public Mobile save (Mobile mobile)
    {
        mobile.setCreatedAt(new Date());
        return mobileRepository.save(mobile);
    }

    @Override
    public void delete (Long id)
    {
        mobileRepository.deleteById(id);
    }

    @Override
    public Page<Mobile> getWithPagination (int pageNo, int pageSize, String sortField, String sortDirection)
    {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return mobileRepository.findAll(pageable);
    }
}
