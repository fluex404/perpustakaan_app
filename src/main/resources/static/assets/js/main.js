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

	/* first reload */
	$('.msg').hide();

	/* My Global variable */
	var file_upload_base64;
	var message;

	/* upload image take the base64 code */
	function convertFileToBase64(input) {
		if(input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				// console.log(e.target.result);
				file_upload_base64 = e.target.result;
			};
			reader.readAsDataURL(input.files[0]);
		}
	}

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
		var url = $('#profile-form').attr('action');

		// console.log(updateProfile);

		$.ajax({
			url: url,
			type: 'post',
			dataType: 'json',
			contentType: 'application/json',
			success: function (data) {
				if(data) {
					$('.msg').show();

					// update data Profile
					$('#profile-img').attr('src', data.photo);
					$('#profile-name input').val(data.name);
					$('#profile-email input').val(data.email);
					$('#profile-username').val(data.username);
					$('#profile-password').val(data.password);
				}
			},
			data: JSON.stringify(updateProfile)
		});

	});

    // Close my code
});
