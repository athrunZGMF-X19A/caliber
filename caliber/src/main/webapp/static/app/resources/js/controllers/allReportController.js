angular
		.module("charts")
		.controller(
				"allReportController",
				function($scope, $log, caliberDelegate, chartsDelegate,
						allBatches) {

					$log.debug("Booted Report Controller");
					$log.debug("Peacepapi is here!!!!!");

					(function start() {
						// Finishes any left over ajax animation from another
						// page
						NProgress.done();

						// batch null check
						if (!allBatches || allBatches.length === 0) {
							$scope.noBatches = true;
							$scope.noBatchesMessage = "No Batches belonging to you were found.";
						} else {
							$scope.noBatches = false;
							$log.debug("Here AGAIN!!!!!!");
							createDefaultCharts();
						}
					})();

					/**
					 * ********************************************* UI
					 * **************************************************
					 */
					var viewCharts = 0;

					$scope.batches = allBatches;
					$scope.currentBatch = {
						trainingName : "Batch"
					};
					$scope.currentTrainee = {
						name : "Trainee"
					};

					// hide filter tabs
					$scope.hideOtherTabs = function() {
						return $scope.currentBatch.trainingName !== "Batch";
					};

					// show charts
					$scope.showCharts = function(charts) {
						return charts === viewCharts;
					};

					function createDefaultCharts() {
						// Finishes any left over ajax animation from another
						// page
						NProgress.done();
						NProgress.start();
						chartsDelegate.doughnut.data
								.getQCStatsData(1050, 1)
								.then(
										function(data) {
											NProgress.done();
											var doughnutChartObject = chartsDelegate.doughnut
													.getQCStats(data);
											console.log("here we are, in the pie method");
											console.log(doughnutChartObject);
											$scope.qcStatsLabels = doughnutChartObject.labels;
											$scope.qcStatsData = doughnutChartObject.data;
											$scope.qcStatsOptions = doughnutChartObject.options;
										}, function() {
											NProgress.done();
										});

					}
					
					/**
					 * Generates a PDF by sending HTML to server.
					 * Downloads automatically in new tab.
					 */
					$scope.generatePDF = function() {
						var html = "<div>Extract report contents into here</div>";
						caliberDelegate.all.generatePDF(html).then(
								function(pdf) {
									// extract PDF bytes
									var file = new Blob([ pdf ], {
										type : "application/pdf"
									});
									// create temporary 'url' and download automatically
									var fileURL = URL.createObjectURL(file);
									var a = document.createElement("a");
									a.href = fileURL;
									a.target = "_blank";
									a.download = "report.pdf";
									document.body.appendChild(a);
									a.click();

								}, function(error) {
									$log.debug(reason);
								}, function(value) {
									$log.debug(value);
								});
					}

				});
