function validateInput(input, inputFormat) {
	return inputFormat.test(input);
}

function validateFirstName(name) {
	const namePattern = new RegExp("^[A-Z]{1}[A-Za-z]{2}");
	if (!validateInput(name, namePattern))
		document.getElementById("warnFname").innerHTML = "<font class=warnTxt>Enter Valid First Name</font>";
	else
		document.getElementById("warnFname").innerHTML = "";
}

function validateLastName(name) {
	const namePattern = new RegExp("^[A-Z]{1}[A-Za-z]{2}");
	if (!validateInput(name, namePattern))
		document.getElementById("warnLname").innerHTML = "<font class=warnTxt>Enter Valid Last Name</font>";
	else
		document.getElementById("warnLname").innerHTML = "";
}

function validatePhone(phone) {
	const phonePattern = new RegExp("^[6-9][0-9]{9}$");
	if (!validateInput(phone, phonePattern))
		document.getElementById("warnPhone").innerHTML = "<font class=warnTxt>Enter Valid Number</font>";
	else
		document.getElementById("warnPhone").innerHTML = "";
}

function validateCity(city) {
	const cityPattern = new RegExp("^[A-Z]{1}[A-Za-z]{2}");
	if (!validateInput(city, cityPattern))
		document.getElementById("warnCity").innerHTML = "<font class=warnTxt>Enter Valid City</font>";
	else
		document.getElementById("warnCity").innerHTML = "";
}

function validateZip(zip) {
	const zipPattern = new RegExp("^[0-9]{5}");
	if (!validateInput(zip, zipPattern))
		document.getElementById("warnZip").innerHTML = "<font class=warnTxt>Enter Valid Zip</font>";
	else
		document.getElementById("warnZip").innerHTML = "";
}

var states = new Array();
states = new Array('Andhra Pradesh', 'Arunachal Pradesh', 'Assam', 'Bihar', 'Chhattisgarh', 'Goa', 'Gujarat', 'Haryana', 'Himachal Pradesh', 'Jammu and Kashmir', 'Jharkhand', 'Karnataka', 'Kerala', 'Madhya Pradesh', 'Maharashtra', 'Manipur', 'Meghalaya', 'Mizoram', 'Nagaland', 'Odisha', 'Punjab', 'Rajasthan', 'Sikkim', 'Tamil Nadu', 'Telangana', 'Tripura', 'Uttar Pradesh', 'Uttarakhand', 'WestBengal', 'Andaman and Nicobar Islands', 'Chandigarh', 'Dadra and Nagar Haveli', 'Daman and Diu', 'Lakshadweep', 'Puducherry');

function setStates() {
	var newOptions = states;
	selectField = document.getElementById("state");
	selectField.options.length = 0;
	for (i = 0; i < newOptions.length; i++) {
		selectField.options[selectField.length] = new Option(newOptions[i]);
	}
}

//////////////////////////////////////////////////////////////////////

function addRecord() {
	var firstName = document.getElementById('fname').value;
	var lastName = document.getElementById('lname').value;
	var address = document.getElementById('address').value;
	var cityName = document.getElementById('city').value;
	var zipCode = document.getElementById('zip').value;
	var mobileNumber = document.getElementById('phone').value;

	personalities.push(new person(firstName, lastName, address, cityName, state, zipCode, mobileNumber));
}


function person(firstName, lastName, address, cityName, stateName, zipCode, mobileNumber) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.cityName = cityName;
	this.stateName = stateName;
	this.zipCode = zipCode;
	this.mobileNumber = mobileNumber;
	this.toString = function () {
		return this.firstName + "\n " +
			this.lastName + "\n " +
			this.address + "\n " +
			this.cityName + "\n " +
			this.stateName + "\n " +
			this.zipCode + "\n " +
			this.mobileNumber + "\n ";
	};
	function getName(){
		return this.firstName;
	}
	return this;
}

var personalities = new Array();

// function displayRecord() {
// 	document.getElementById("values").innerHTML = "<div ><br><br><br><br><br><br><br><br></div>" + personalities;
// }

function displayRecord() {
	// var str = '<ul>'

	// personalities.forEach(function(slide) {
	//   str += '<li>'+ slide.getName() + '</li>';
	// }); 
	
	
	// personalities.forEach(function(message){
	// 	str +='<p class="p2">' + message.firstName +'</p>';
	// 	console.log("Iam heres  "+str)
	// });
	// str += '</ul>';
	// document.getElementById("values").innerHTML = str;

	let table = '';
	for (let row = 0; row< personalities.length; row++) {
		table += '<tr>';
		table += '<td>' + personalities.firstName + '</td>' + '<td>' + personalities.lastName + '</td>' + '<td>' + personalities.address + '</td>' + '</tr>';
	}
	console.log("Here its is" + table);
	document.getElementById("values").innerHTML = table;
}

let state;
function setState() {
	state = document.getElementById('state').value;
}

