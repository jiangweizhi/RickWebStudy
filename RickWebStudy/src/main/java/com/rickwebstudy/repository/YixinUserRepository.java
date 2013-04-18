package com.rickwebstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickwebstudy.entity.YixinUser;
import com.rickwebstudy.repository.custom.YixinUserRepositoryCustom;

public interface YixinUserRepository extends JpaRepository<YixinUser, Long>, YixinUserRepositoryCustom{

}
