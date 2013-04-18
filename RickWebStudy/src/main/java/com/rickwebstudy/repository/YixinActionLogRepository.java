package com.rickwebstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rickwebstudy.entity.YixinActionLog;
import com.rickwebstudy.repository.custom.YixinActionLogRepositoryCustom;

public interface YixinActionLogRepository extends JpaRepository<YixinActionLog, Long>, YixinActionLogRepositoryCustom{

}
