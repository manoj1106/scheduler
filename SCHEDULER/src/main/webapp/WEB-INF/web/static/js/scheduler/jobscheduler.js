var jobscheduler = {};

$(function(){
	jobscheduler.buttonClick();
});

jobscheduler.buttonClick = function() {
	$('.jobscheduler').off('click').on('click',function(e) {
		e.preventDefault();
		var url = 'jobScheduler/';
		var isProcessReq = false;
		if($(this).hasClass('jobgroup')) {
			url = url + 'jobScheduleGroupNameCreation';
			isProcessReq = jobscheduler.validateJobgroup();
		} else if($(this).hasClass('jobschedule')) {
			url = url + 'jobScheduleCreation';
			isProcessReq = jobscheduler.validateJobgroup();
		}
		
		if(isProcessReq) {
			var json = JSON.stringify($('#jobschedulerform').serializeObject());
			var response = schedulerfunctions.ajaxServerRequestResponse(url , null , json);
			schedulerfunctions.printSuccessErrorMessage(response);
		}
	});
}

jobscheduler.validateJobgroup = function() {
	if(schedulerutil.isBlank($('#jobGroupName').val())) {
		schedulerfunctions.printNotificationMessage(constants.message.blankInputError,constants.notificationMsg.error);
		return false;
	}
	return true;
}