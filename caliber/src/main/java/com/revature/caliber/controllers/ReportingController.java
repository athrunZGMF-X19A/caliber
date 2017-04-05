package com.revature.caliber.controllers;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.beans.Assessment;
import com.revature.caliber.beans.AssessmentType;
import com.revature.caliber.beans.Batch;
import com.revature.caliber.beans.Category;
import com.revature.caliber.beans.QCStatus;
import com.revature.caliber.beans.Trainee;
import com.revature.caliber.services.ReportingService;

/**
 * Exclusively used to generate data for charts
 * 
 * @author Patrick Walsh
 *
 */
@RestController
public class ReportingController {

	private final static Logger log = Logger.getLogger(ReportingController.class);
	private ReportingService reportingService;

	@Autowired
	public void setReportingService(ReportingService reportingService) {
		this.reportingService = reportingService;
	}

	/*
	 *******************************************************
	 * TODO ORGANIZE SERVICES
	 *
	 *******************************************************
	 */
	/**
	 * For Displaying line graph of all trainee in batch and Avg score
	 * @Author Pier Yos
	 * @param batchId
	 * @param week
	 * @return JSON result of Map<Trainee, Double>
	 */
	@RequestMapping(value = "/all/reports/week/batch/{batchId}/week/{week}/bar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<Trainee, Double>> getBatchWeeklyAvgAssessmentScore(@PathVariable int batchId,@PathVariable int week){
		
		throw new UnsupportedOperationException("Not yet implemented");
	}
	/**
	 * Get aggregated grades by Category for a Trainee
	 *
	 * @param traineeId
	 * @return
	 */
	@RequestMapping(value = "/agg/tech/trainee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HashMap<Trainee, Double[]>> aggregateTechTrainee(@PathVariable("id") int traineeId) {
		// TODO implement me
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * Get aggregated grades by Week for a Trainee
	 *
	 * @param traineeId
	 * @return
	 */
	@RequestMapping(value = "/agg/week/trainee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HashMap<Trainee, Double[]>> aggregateWeekTrainee(@PathVariable("id") int traineeId) {
		// TODO implement me
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * Get aggregated grades by Category for a Batch
	 *
	 * @param batchId
	 * @return
	 */
	@RequestMapping(value = "/agg/tech/batch/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HashMap<Batch, Double[]>> aggregateTechBatch(@PathVariable("id") int batchId) {
		// TODO implement me
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * Get aggregated grades by Category for a Batch
	 *
	 * @param traineeId
	 * @return
	 */
	@RequestMapping(value = "/agg/week/batch/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HashMap<Batch, Double[]>> aggregateWeekBatch(@PathVariable("id") int batchId) {
		// TODO implement me
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * Get aggregated grades for all Trainees by Trainer
	 *
	 * @param traineeId
	 * @return
	 */
	@RequestMapping(value = "/agg/batch/trainer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Double[]>> aggregateTraineesTrainer(@PathVariable("id") int trainerId) {
		// TODO implement me
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public ResponseEntity<Map<Trainee, Double>> findAvgGradesForEachTrainee() {
		// TODO implement me
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public ResponseEntity<Map<Assessment, Double>> findAvgGradesForEachAssessment() {
		// TODO implement me
		throw new UnsupportedOperationException("Not yet implemented");
	}

	public ResponseEntity<Map<Category, Double>> findAvgGradeByCategory(int traineeId) {
		// TODO implement me
		throw new UnsupportedOperationException("Not yet implemented");
	}
	/**
	 * 
	 * @param batchId
	 * @param week
	 * @param traineeId
	 * @return
	 */
	@RequestMapping(value = "/all/reports/batch/{batchId}/week/{week}/trainee/{traineeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<Integer, Double> >lineCharAVG(@PathVariable int batchId, @PathVariable int week, @PathVariable int traineeId){
		return new ResponseEntity<Map<Integer, Double>>(reportingService.lineCharAVG(batchId, week, traineeId),  HttpStatus.OK);
	}
	/**
	 * 
	 * @param traineeId
	 * @return
	 */
	@RequestMapping(value = "/all/reports/batch/trainee/{traineeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<Integer, Double>> findAvgGradeByWeek(@PathVariable int traineeId) {
		return new ResponseEntity<Map<Integer, Double>>(reportingService.findAvgGradeByWeek(traineeId),  HttpStatus.OK);
	}
	/**
	 * 
	 * @param batchId
	 * @param week
	 * @return
	 */
	@RequestMapping(value = "/all/reports/batch/{batchId}/week/{week}/barchart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<Trainee, Double>> barCharAVG(@PathVariable int batchId, @PathVariable int week) {
		
		return new ResponseEntity<Map<Trainee, Double>>(reportingService.barCharAVG(batchId, week),  HttpStatus.OK);
	}

	@RequestMapping(value = "/agg/tech/batch/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HashMap<Category, HashMap<Batch, Double[]>>> aggregateTechForAllBatches() {
		// TODO implement me
		throw new UnsupportedOperationException("Not yet implemented");
	}

	@RequestMapping(value = "/reports/batch/{batchId}/week/{weekId}/pie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HashMap<QCStatus,Integer>> aggregateQCPieChart(@PathVariable Integer batchId, @PathVariable Integer weekId) {
		
		HashMap<QCStatus,Integer> results = (HashMap<QCStatus, Integer>) reportingService.batchWeekPieChart(batchId, weekId);
		
		
		return new ResponseEntity<HashMap<QCStatus,Integer>>(results, HttpStatus.OK);
	}


	
	
	
	
	
	
	//assessmentType is case sensitive so call with uppercase first letter
	@RequestMapping(value = "/reports/{week}/{batchId}/{assessmentType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<Trainee, Double[]>> getAvgBatchWeek(@PathVariable Integer batchId,
			@PathVariable Integer week, @PathVariable AssessmentType assessmentType) {
		return new ResponseEntity<Map<Trainee, Double[]>>(reportingService.getAvgBatchWeek(batchId, week, assessmentType), HttpStatus.OK);
	}
	
	
	
	
	
}
