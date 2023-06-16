package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.NewDTO;

public interface INewService {
	NewDTO save(NewDTO newDTO); // khi new 1 bài viết mới thì phải trả về cho nó dto
	void delete(long[] ids);
	List<NewDTO> findAll(Pageable pageable);
	List<NewDTO> findAll();
	int totalItem();
}
