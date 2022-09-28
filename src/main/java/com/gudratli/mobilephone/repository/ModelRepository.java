package com.gudratli.mobilephone.repository;

import com.gudratli.mobilephone.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long>
{
    Model findByName (String name);
}