package com.rickwebstudy.repository.custom;

import java.util.List;

import com.rickwebstudy.entity.YixinUser;

public interface YixinUserRepositoryCustom {
	List<YixinUser> getYixinUserByDeviceId(Long deviceId);
}
