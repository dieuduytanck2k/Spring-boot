package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.api.output.NewOutput;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.INewService;

@RestController // @RestController = @Controller + @ResponseBody
public class NewAPI {
	
	@Autowired
	private INewService newService;
	
	@GetMapping(value = "/new") // @PostMapping = @RequestMapping + method 
	public NewOutput showNew(@RequestParam(value ="page", required = false) Integer page,
							 @RequestParam(value ="limit", required = false) Integer limit) { // @RequestBody sẽ matching các value tương ứng với các thuộc tính trong DTO
		NewOutput result = new NewOutput();
		if (page != null && limit != null) {
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(newService.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
		} else {
			result.setListResult(newService.findAll());
		}
		return result;
	}
	
	@PostMapping(value = "/new") // @PostMapping = @RequestMapping + method 
	public NewDTO createNew(@RequestBody NewDTO model) { // @RequestBody sẽ matching các value tương ứng với các thuộc tính trong DTO
		return newService.save(model);
	}
	
	@PutMapping(value = "/new/{id}") // @PutMapping = @RequestMapping + method 
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") long id) { // @RequestBody sẽ matching các value tương ứng với các thuộc tính trong DTO
		model.setId(id);
		return newService.save(model);
	}
	
	@DeleteMapping(value = "/new") // @PutMapping = @RequestMapping + method 
	public void deleteNew(@RequestBody long[] ids) { // @RequestBody sẽ matching các value tương ứng với các thuộc tính trong DTO
		newService.delete(ids);
	}
}
