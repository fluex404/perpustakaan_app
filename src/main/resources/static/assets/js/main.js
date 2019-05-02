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
	firstLoadData();

	/* My Global variable */
	var file_upload_base64;

	/* my function */
	function firstLoadData() {
		profileLoad();
	}
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

	function profileLoad() {
		/* action before run */
		$('#profile-email div').hide();
		$('#profile-nama div').hide();
		$('.msg').hide();

		/* get data of server into global variable */
		$.get('/api/profile', function(data){
			$('#profile-img').attr('src', data.photo);
			$('#profile-id').val(data.id);
			$('#profile-nama input').val(data.nama);
			$('#profile-email input').val(data.email);
			$('#profile-username input').val(data.username);
			$('#profile-password input').val(data.password);
		});
	}

	$('#profile-photo input').change(function(e){
		convertFileToBase64(this);
	});

	$('#profile-submit').click(function(e){
		e.preventDefault();

		var updateProfile = {
			id: $('#profile-id').val(),
			nama: $('#profile-nama input').val(),
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
					if(data.status === "error" ) {

						if(typeof data.nama !== 'undefined'){
							$('#profile-nama input').addClass("is-invalid");
							$('#profile-nama div').text(data.nama).show();
						}

						if(typeof data.email !== 'undefined') {
							$('#profile-email input').addClass('is-invalid');
							$('#profile-email div').text(data.email).show();
						}
					}
					else {
						$('.msg').show();
						$('#profile-nama input').removeClass("is-invalid");
						$('#profile-email input').removeClass('is-invalid');

						// update data Profile
						$('#profile-img').attr('src', data.photo);
						$('#profile-nama input').val(data.nama);
						$('#profile-email input').val(data.email);
						$('#profile-username').val(data.username);
						$('#profile-password').val(data.password);
					}
				}
			},
			data: JSON.stringify(updateProfile)
		});

	});

    // Close my code
});
