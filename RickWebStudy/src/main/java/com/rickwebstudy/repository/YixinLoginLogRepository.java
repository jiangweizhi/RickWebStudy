package com.rickwebstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickwebstudy.entity.YixinLoginLog;
import com.rickwebstudy.repository.custom.YixinLoginLogRepositoryCustom;

public interface YixinLoginLogRepository extends JpaRepository<YixinLoginLog, Long>, YixinLoginLogRepositoryCustom{

}
