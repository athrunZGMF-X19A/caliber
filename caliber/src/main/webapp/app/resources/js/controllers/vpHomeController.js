angular.module("vp").controller(
		"vpHomeController",
		function($scope, $log, delegateFactory) {
			$log.debug("Booted vp home controller.");

			// VP API Test
			$log.log("Get All Batches: ");
			$log.log(delegateFactory.vp.getAllBatches());
			$log.log("Get All Current Batches: ");
			$log.log(delegateFactory.vp.getAllCurrentBatches());
			$log.log("Get Batch With Id: ");
			$log.log(delegateFactory.vp.getBatch(7));
			$log.log("Get Current Batch with Id: ");
			$log.log(delegateFactory.vp.getCurrentBatch(5));
			
			// Dropdown menu selection
			$scope.batches = [ "Batch1311", "Batch1612", "Batch1512", "Batch1812", "Batch0910", "Batch0805", "Batch0408" ];
			$scope.tech = [ "Spring", "Hibernate", "JSP" ];
			$scope.trainees = [ "Osher", "Kyle", "Rikki" ];
			
      $scope.currentBatch = $scope.batches[0];
			
			$scope.currentTech = "Technology";
				
			$scope.currentTrainee = "Trainee";
			
			$scope.selectCurrentBatch = function(index){
				$scope.currentBatch = $scope.batches[index];
			};
			
			$scope.selectCurrentTech = function(index){
				$scope.currentTech = $scope.tech[index];
			};
			
			$scope.selectCurrentTrainee = function(index){
				$scope.currentTrainee = $scope.trainees[index];
			};

			// batch rank comparison - radar chart
			$scope.batchRankLabels = [ "Java", "Servlet", "Spring",
					"Hibernate", "REST", "SOAP", "Javascript", "Angular" ];

			$scope.batchRankData = [ [ 65, 59, 90, 81, 56, 55, 40, 89 ],
					[ 28, 48, 40, 19, 96, 27, 100, 78 ] ];

			$scope.batchRankSeries = [ "Average", "Batch" ];

			// trainer qc eval chart
			$scope.labels = ["Patrick", "Joe", "Brian", "Karan",
				"Steven", "Nick", "Richard", "Fred", "Genesis", "Emily", "Ankit", "Ryan"];
		    $scope.series = ['QC Eval'];

		    $scope.data = [
		      [70, 78, 80, 81, 85, 90, 70, 66, 89, 100, 78, 89]
		    ];

		});