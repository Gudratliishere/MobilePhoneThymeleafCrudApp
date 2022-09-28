package com.gudratli.mobilephone.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "models")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Model
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne
    @NonNull
    private Brand brand;
}
