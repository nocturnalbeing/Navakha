package com.navakha.basic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navakha.basic.Entities.FlagForKey;
import java.lang.String;
import java.util.List;

public interface FlagforKeyRepository extends JpaRepository<FlagForKey, Long>{
	List<FlagForKey> findByKeyname(String keyname);

}
