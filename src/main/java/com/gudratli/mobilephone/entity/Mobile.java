package com.gudratli.mobilephone.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mobiles")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Mobile
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String price;
    @NonNull
    private String phone;
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    @ManyToOne
    @NonNull
    private Model model;
    private Date createdAt;
}
