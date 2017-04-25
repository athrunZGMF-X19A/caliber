angular.module("reportApi").factory(
		"lineChartDataFactory",
		function($http, $log) {
			$log.debug("Booted Line Chart Data Factory");

			var report = {};

			/**
			 * Yanilda
			 */
			report.getTraineeUpToWeekLineChart = function(batchId, week, traineeId) {
				return $http(
						{
							url : "/all/reports/batch/" + batchId + "/week/" + week
									+ "/trainee/" + traineeId
									+ "/line-trainee-up-to-week",
							method : "GET"
						}).then(function(response) {
					$log.debug("Agg - Batch - week-- trainee -- success");
					$log.debug(response);
					return response.data;
				}, function(response) {
					$log.error("There was an error: " + response.status);
				});
			};
			//Hossain
			report.getTraineeOverallLineChart = function(batchId, traineeId) {

				return $http({
					url : "/all/reports/batch/" + batchId
						+ "/overall/trainee/" + traineeId
						+ "/line-trainee-overall",
					method : "GET"
				}).then(function(response) {
					$log.debug("All-reports-Batch-overall-trainee-overall");
					$log.debug(response);
					return response.data;
				}, function(response) {
					$log.error("There was an error: " + response.status);
				});
			};
			
			report.getBatchOverallLineChartData = function(batchId) {
				return $http({
					url : "/all/reports/batch/" + batchId + " /overall/line-batch-overall",
					method : "GET"
				}).then(
				function(response) {
					$log.debug("Batch -> Overall -> line chart");
					$log.debug(response);
					return response.data;
				}, 
				function(response) {
					$log.error("There was an error in lineChartDataFactory -> getBatchOverallLineChart. " + response.status);
				});	
			};
			/**
			 * This is for the vpHome LineChart
			 */
			report.getCurrentBatchesAverageScoreChartData = function() {
				return $http(
						{
							url : '/vp/reports/dashboard',
							method : "GET"
						}).then(function(response) {
					$log.debug("VP -> All Current Batches -> Weekly  Averages");
					$log.debug(response);
					return response.data;
				}, function(response) {
					$log.error("There was an error: " + response.status);
				});
			};
		return report;
	}
);
