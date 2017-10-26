var jobscheduler = {};

$(function(){
	jobscheduler.buttonClick();
	var requestFor = $('#requestFor').val();
	if(schedulerutil.isNotBlank(requestFor) && requestFor == 'jobschedule') {
		jobscheduler.getJobGroupNames();
		jobscheduler.setScheduleAt();
	}
});

jobscheduler.buttonClick = function() {
	$('.jobscheduler').off('click').on('click',function(e) {
		e.preventDefault();
		var url = 'jobScheduler/';
		var isProcessReq = false;
		var json = '';
		var jsonObj = {};
		if($(this).hasClass('jobgroup')) {
			url = url + 'jobScheduleGroupNameCreation';
			isProcessReq = jobscheduler.validateJobgroup();
			if(isProcessReq) {
				json = JSON.stringify($('#jobschedulerform').serializeObject());
			}
		} else if($(this).hasClass('jobschedule')) {
			url = url + 'jobScheduleCreation';
			isProcessReq = jobscheduler.validateJobSchedule(jsonObj);
			if(isProcessReq) {
				json = jobscheduler.getJobScheduleJson();
				console.log(json);
			}
		}
		
		if(isProcessReq) {
			//var response = schedulerfunctions.ajaxServerRequestResponse(url , null , json);
			//schedulerfunctions.printSuccessErrorMessage(response);
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

jobscheduler.getJobScheduleJson = function() {
	var jsonObj = {};
	var jobGroupName = $('#jobGroupName').val();
	var jobName = $('#jobName').val();
	var scheduleOn = $('input.scheduleOn:checkbox:checked');
	var inboundQueue = $('#inboundQueue').val();
	var scheduleAt = $('#hour').val() + ":" + $('#minutes').val() + ":" + $('#seconds').val();
	
	var arr = [];
	
	$(scheduleOn).each(function(){
		console.log($(this).val());
		arr.push($(this).val());
	});
	
	jsonObj = {
		jobGroupName : jobGroupName,
		jobName : jobName,
		inboundQueue : inboundQueue,
		outboundQueue : outboundQueue,
		scheduleAt : scheduleAt,
		jobGroupName : jobGroupName,
		scheduleOn : arr,
		dependentjobName : $('#dependentjobName').val(),
		isCritical : $('#isCritical').is(':checked'),
		isSkip : $('#isSkip').is(':checked')
	};
	
	return JSON.stringify(jsonObj);
}


jobscheduler.validateJobSchedule = function(jsonObj) {
	
	var jobGroupName = $('#jobGroupName').val();
	var scheduleOn = $('input.scheduleOn:checkbox:checked');
	var scheduleAt = $('#hour').val() + ":" + $('#minutes').val() + ":" + $('#seconds').val();
	
	$('#messageId').text('');
	
	if(schedulerutil.isBlank(jobGroupName) || jobGroupName == 'select' ) {
		schedulerfunctions.printNotificationMessage(constants.message.blankInputError,constants.notificationMsg.error);
		return false;
	}
	if(schedulerutil.isBlank($('#jobName').val())) {
		$('#jobName').val('');
		schedulerfunctions.printNotificationMessage(constants.message.blankInputError,constants.notificationMsg.error);
		return false;
	}
	if(scheduleOn.length == 0) {
		schedulerfunctions.printNotificationMessage(constants.message.blankInputError,constants.notificationMsg.error);
		return false;
	}
	if(schedulerutil.isBlank(scheduleAt) || scheduleAt == '00:00:00') {
		schedulerfunctions.printNotificationMessage(constants.message.blankInputError,constants.notificationMsg.error);
		return false;
	}
	if(schedulerutil.isBlank($('#inboundQueue').val())) {
		$('#inboundQueue').val('');
		schedulerfunctions.printNotificationMessage(constants.message.blankInputError,constants.notificationMsg.error);
		return false;
	}
	if(schedulerutil.isBlank($('#outboundQueue').val())) {
		$('#outboundQueue').val('');
		schedulerfunctions.printNotificationMessage(constants.message.blankInputError,constants.notificationMsg.error);
		return false;
	}
	
	return true;
}

jobscheduler.getJobGroupNames = function() {
	var url = 'jobScheduler/getJobGroupNames';
	var response = schedulerfunctions.ajaxServerRequestResponseWithoutJsonObj(url);
	var jobGroupNames = response.dataMap.jobGroupNames;
	if(schedulerutil.isNotNullOrUndefined(jobGroupNames)) {
		if(jobGroupNames.length > 0) {
			$('#jobGroupName').empty();
			var option = '<option value="select">--select--</option>';
			$(jobGroupNames).each(function(index) {
				var optval = jobGroupNames[index];
				option = option + '<option value="' + optval + '">' + optval + '</option>';
			});
			$('#jobGroupName').append(option);
		}
	} else {
		schedulerfunctions.printSuccessErrorMessage(response);
	}
}

jobscheduler.setScheduleAt = function() {
	var hour = 24, mins = 60;
	$('#hour').empty();
	$('#minutes').empty();
	$('#seconds').empty();
	var option = '<option value="00">00</option>';
	var value = '';
	for(var i = 1; i <= hour; i++) {
		value = '';
		if(i < 10) {
			value = '0';
		}
		value = value + i;
		option = option + '<option value="' + value + '">' + value + '</option>';
	}
	$('#hour').append(option);
	option = '<option value="00">00</option>';
	for(var i = 1; i <= mins; i++) {
		value = '';
		if(i < 10) {
			value = '0';
		}
		value = value + i;
		option = option + '<option value="' + value + '">' + value + '</option>';
	}
	$('#minutes').append(option);
	$('#seconds').append(option);
}