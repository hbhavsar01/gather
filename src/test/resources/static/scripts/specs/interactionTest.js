
describe("front end email password tests", function () {
 
    it("correct email", function() {
    	var isEmail = validateEmail("hello@gmail.com");
    	expect(isEmail).toBe(true);
    });
    
    it("two dot email (@korea.co.kr, @spain.go.sp)", function() {
    	var isEmail = validateEmail("hello@korea.co.kr");
    	expect(isEmail).toBe(true);
    });
    
    it("email missing @", function() {
    	var isEmail = validateEmail("hellogmail.com");
    	expect(isEmail).toBe(false);
    });
    
    it("email missing .", function() {
    	var isEmail = validateEmail("hello@gmailcom");
    	expect(isEmail).toBe(false);
    });
      
    it("correct password", function() {
    	var validPass = validatePass("password");
    	expect(validPass).toBe(true);
    });
    
    it("short password", function() {
    	var validPass = validatePass("as");
    	expect(validPass).toBe(false);
    });
    
    it("long password", function() {
    	var validPass = validatePass("assadfwefwawefwafefsefawefe");
    	expect(validPass).toBe(false);
    });
    
    it("correct display name", function() {
    	var validPass = validatePass("helloworld");
    	expect(validPass).toBe(true);
    });
    
    it("short display name", function() {
    	var validPass = validatePass("as");
    	expect(validPass).toBe(false);
    });
    
    it("long display name", function() {
    	var validPass = validatePass("assadfwefwawefwafefsefawefe");
    	expect(validPass).toBe(false);
    });
    
});

describe("zip code button click test", function() {
	beforeEach(function () {
			loadFixtures('rightpane/map.html');
		});
	  
	  it("empty zip code", function() {
	    runs(function() {
	    	$("#enterZip").trigger('click');
	    });

	    waitsFor(function() {
	    	return ($('#zipCodeErrorBox').html() == 'Zip code field is empty')
	    }, "no response after clicking #enterZip", 2000);

	    runs(function() {
	    	expect($('#zipCodeErrorBox').html()).toBe('Zip code field is empty')
	    });
	  });
	  
	  it("non-five-digit zip code", function() {
		    runs(function() {
		    	$("#zipCode").val('1034');
		    	$("#enterZip").trigger('click');
		    });

		    waitsFor(function() {
		    	return ($('#zipCodeErrorBox').html() == 'Zip code must be five digits')
		    }, "no response after clicking #enterZip", 2000);

		    runs(function() {
		    	expect($('#zipCodeErrorBox').html()).toBe('Zip code must be five digits')
		    });
		  });
	  
	  it("non-digit zip code", function() {
		    runs(function() {
		    	$("#zipCode").val('asdff');
		    	$("#enterZip").trigger('click');
		    });

		    waitsFor(function() {
		    	return ($('#zipCodeErrorBox').html() == 'Zip code must be five digits')
		    }, "no response after clicking #enterZip", 2000);

		    runs(function() {
		    	expect($('#zipCodeErrorBox').html()).toBe('Zip code must be five digits')
		    });
		  });
	  
//	  it("non-existing zip code", function() {
//		    runs(function() {
//		    	$("#zipCode").val('13025');
//		    	$("#enterZip").trigger('click');
//		    });
//
//		    waitsFor(function() {
//		    	return ($('#zipCodeErrorBox').html() == 'Zip code does not exist')
//		    }, "no response after clicking #enterZip", 10000);
//
//		    runs(function() {
//		    	var htmlValue = $('#zipCodeErrorBox').html();
//		    	expect(htmlValue).toBe('Zip code does not exist')
//		    });
//		  });
	});

describe("register form tests", function () {
	beforeEach(function () {
		//jasmine-jquery.js defines Fixtures root to be 
		//'src/main/resources/templates' on line 40.
		loadFixtures('registerform.html');
		$("#inputEmail").val('test@email.com');
    	$("#inputPassword1").val('password1');
    	$("#inputPassword2").val('password2');
    	$("#inputDisplayName").val('iamthetestuser');
	});

	it("clicks the #registerFormSubmit", function() {
		spyOnEvent($('#registerFormSubmit'), 'click');
    	$("#registerFormSubmit").trigger('click');
    	expect('click').toHaveBeenTriggeredOn($('#registerFormSubmit'));
	});

//    it("check registration form confirm password", function() {
//    	// submitting the form with information in beforeEach
//    	$("#registerFormSubmit").trigger('click');
//
////    	waitsFor(function() {
////    		var formFeedback = $('#formFeedback').html();
////    		return (formFeedback=='Passwords do not match');
////    	  }, 'register form was never clicked', 2000);
//    	
//    	var formFeedback = $('#formFeedback').html();
//        var expectedFormFeedback = 'Passwords do not match';
////   	 we expect warning saying that passwords do not match 	
//        expect(formFeedback).toBe(expectedFormFeedback)
//
//    });	 
    
    it("registration form exists", function() {
    	var formExists = false
    	if ($('#registration').length){
    		formExists = true
        }
    	expect(formExists).toBe(true)
    });
	
    it("jasmine enters values to registration form", function() {
    	// expect the form to contain information in beforeEach
    	var email = $('#inputEmail').val();
    	var password1 = $('#inputPassword1').val();
    	var password2 = $('#inputPassword2').val();
    	var displayName = $('#inputDisplayName').val();
    	expect(email).toBe('test@email.com')
    	expect(password1).toBe('password1')
    	expect(password2).toBe('password2')
    	expect(displayName).toBe('iamthetestuser')
    });
	

});	 