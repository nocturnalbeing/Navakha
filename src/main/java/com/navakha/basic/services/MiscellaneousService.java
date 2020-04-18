package com.navakha.basic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navakha.basic.Entities.FlagForKey;
import com.navakha.basic.repositories.FlagforKeyRepository;

@Service
public class MiscellaneousService {
	@Autowired
	FlagforKeyRepository flagforKeyRepository;
	public  String generateBitKeyForPost() {
		
		List<FlagForKey> flagList = flagforKeyRepository.findByKeyname("photoStatus");
		if (flagList.size() == 0) {
			FlagForKey flagForKey = new FlagForKey();
			flagForKey.setTokenNumber(1l);
			flagForKey.setKeyname("photoStatus");
			flagForKey.setTokenKey("NAVAKHAPOST" + 1);
			flagforKeyRepository.save(flagForKey);
			return flagForKey.getTokenKey();
		} else {
			FlagForKey newFlag = flagList.get(0);
			newFlag.setTokenNumber(newFlag.getTokenNumber() + 1);
			newFlag.setTokenKey("NAVAKHAPOST" + (newFlag.getTokenNumber()));
			flagforKeyRepository.save(newFlag);
			return newFlag.getTokenKey();
		}
	}
	

}
