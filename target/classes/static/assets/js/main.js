$.noConflict();

jQuery(document).ready(function($) {

	"use strict";

	[].slice.call( document.querySelectorAll( 'select.cs-select' ) ).forEach( function(el) {
		new SelectFx(el);
	} );

	jQuery('.selectpicker').selectpicker;


	$('#menuToggle').on('click', function(event) {
		$('body').toggleClass('open');
	});

	$('.search-trigger').on('click', function(event) {
		event.preventDefault();
		event.stopPropagation();
		$('.search-trigger').parent('.header-left').addClass('open');
	});

	$('.search-close').on('click', function(event) {
		event.preventDefault();
		event.stopPropagation();
		$('.search-trigger').parent('.header-left').removeClass('open');
	});

	// $('.user-area> a').on('click', function(event) {
	// 	event.preventDefault();
	// 	event.stopPropagation();
	// 	$('.user-menu').parent().removeClass('open');
	// 	$('.user-menu').parent().toggleClass('open');
	// });

    // This's my code

	/* upload image take the base64 code */
	var file_upload_base64;

	function convertFileToBase64(input) {
		if(input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				file_upload_base64 = e.target.result;
			};
			reader.readAsDataURL(input.files[0]);
		}
	}

	/* upload image take the base64 code closed */

	/* Profile */
	$('#profile-photo input').change(function(e){
		convertFileToBase64(this);
	});

	$('#profile-submit').click(function(e){
		e.preventDefault();

		var updateProfile = {
			id: $('#profile-id').val(),
			name: $('#profile-name input').val(),
			email: $('#profile-email input').val(),
			username: $('#profile-username input').val(),
			password: $('#profile-password input').val(),
			photo: file_upload_base64
		};


		console.log(updateProfile);
	});

    // Close my code
});
