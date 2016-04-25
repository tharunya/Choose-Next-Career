	jQuery(document).ready(function($) {

		$("#search-form").submit(function(event) {

			// Disable the search button
			searchBtn
			$('.searchBtn').on('click',function() {
			    $(this).prop("disabled",true);
			});

			// Prevent the form from submitting via the browser
			event.preventDefault();

			searchViaAjax(); // implement the method

		});

	});
	
	
