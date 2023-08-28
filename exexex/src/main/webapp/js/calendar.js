/**
 * 
 */

let currentMonth = document.querySelector(".currentMonth");
let currentYear = document.querySelector(".currentYear");

monthPlusHandler = function() {
	if (currentMonth.innerHTML == 12) {
		currentMonth.innerHTML = 1;
		currentYear.innerHTML++;
	} else {
		currentMonth.innerHTML++;
	}
};
monthMinusHandler = function() {
	if (currentMonth.innerHTML == 1) {
		currentMonth.innerHTML = 12;
		currentYear.innerHTML--;
	} else {
		currentMonth.innerHTML--;
	}
};