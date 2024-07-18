package com.telusko.TicketBookingApp.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.TicketBookingApp.Exception.TouristNotFoundException;
import com.telusko.TicketBookingApp.Model.Tourist;
import com.telusko.TicketBookingApp.dao.ITouristRepo;

@Service
public class ITouristImpl implements ITouristManagement
{
	@Autowired
	private ITouristRepo repo;

	@Override
	public String register(Tourist tourist)
	{
		Integer id=repo.save(tourist).getId();
		return "Registeration done with id ="+id;
	}

	@Override
	public List<Tourist> fetchAll()
	{
		List<Tourist> list=repo.findAll();
		
		Collections.shuffle(list);
		
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer id)
	{
		return repo.findById(id).orElseThrow(()->new TouristNotFoundException("Tourist with Given  id "+id+" Not Found"));
	}

	@Override
	public String UpdateTourist(Tourist tourist)
	{
		Optional<Tourist> op=repo.findById(tourist.getId());
		if(op.isPresent())
		{
			repo.save(tourist);
			return "Tourist Information of Id ="+tourist.getId()+" Updated Successfully";
		}
		else
		{
			throw new TouristNotFoundException("No Tourist Exists With GivenInfo");
		}
	}

	@Override
	public String updateBudget(Integer id, Double budget)
	{
		Optional<Tourist> op=repo.findById(id);
		if(op.isPresent())
		{
			Tourist t=op.get();
			t.setBudget(budget);
			repo.save(t);
			return "Tourist Information of Id ="+t.getId()+" Updated Successfully";
		}
		else
		{
			throw new TouristNotFoundException("No Tourist Exists With GivenInfo");
		}
	}

	@Override
	public String removeTouristById(Integer id)
	{
		Optional<Tourist> op=repo.findById(id);
		if(op.isPresent())
		{
		    repo.deleteById(id);
		    return "Data Deleted Succcesfully";
		}
		else
		{
			throw new TouristNotFoundException("No Tourist Found to delete ");
		}
	}

}
