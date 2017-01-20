package com.revature.caliber.assessments.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.caliber.assessments.beans.BatchNote;
import com.revature.caliber.assessments.data.Facade;
import com.revature.caliber.assessments.service.BatchService;


public class BatchNoteServiceImpl implements BatchService {
	 
	private Facade facade;
	
	@Autowired
	public void setFacade(Facade facade) {
	    this.facade = facade;
	}
	
	@Override
	public void makeBatchNote(int batchId, int weekId) {
		facade.makeBatchNote(batchId, weekId);
	}

	@Override
	public BatchNote weeklyBatchNote(int batchId, int weekId) {
		return facade.getWeeklyBatchNote(batchId, weekId);
	}

	@Override
	public List<BatchNote> allBatchNotesInWeek(int weekId) {
		return facade.allBatchNotesInWeek(weekId);
	}
	
}
