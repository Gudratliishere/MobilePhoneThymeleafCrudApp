package com.gudratli.mobilephone.repository;

import com.gudratli.mobilephone.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile, Long>
{
}