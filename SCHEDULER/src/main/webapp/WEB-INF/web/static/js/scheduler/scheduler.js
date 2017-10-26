var schedulerfunctions = {};

$(function() {
	
	var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
	
	$('#page-header').text(constants.pageHeading.dashboard);
	
	schedulerfunctions.loadJspPages();
	schedulerfunctions.cleanup();
});

schedulerfunctions.cleanup = function() {
	$('#side-menu').off('click').on('click',function(){
		$(this).find('li').each(function(){
			var a = $(this).find('a.active');
			$(a).each(function(){
				if($(this).hasClass('active')) {
					$(this).removeClass('active');
				}
			});
			if($(this).hasClass('active')) {
				$(this).removeClass('active');
			}
		});
		$('#messageId').text('');
	});
}

schedulerfunctions.loadJspPages = function() {
	$('a.linkclick').off('click').on('click',function(e) {
		e.preventDefault();
		var url = 'jobScheduler/' + $(this).attr('data-href');
		var pageHeading = '';
		if($(this).hasClass('jobgroup')) {
			pageHeading = constants.pageHeading.jobGroup;
		} else if($(this).hasClass('jobschedule')) {
			pageHeading = constants.pageHeading.jobSchedule;
		}
		$('#messageId').text('');
		$('#parentarea').empty();
		$('#parentarea').load(url);
		$('#page-header').text(pageHeading);
	});
}

schedulerfunctions.ajaxServerRequestResponse = function(url,jsonObj,jsonString) {
	var json ;
	if(schedulerutil.isNullOrUndefined(jsonString)) {
		json = JSON.stringify(jsonObj);
	} else {
		json = jsonString;
	}
	var responseObj = null;
	$.ajax({
		url : url,
		data : json,
		method: constants.ajaxParameter.postmethod,
		type : constants.ajaxParameter.type,
		contentType : constants.ajaxParameter.contentType,
		async : constants.ajaxParameter.asynchfalse,
		success : function(response) {
			responseObj = response;
		},
		error : function() {
			schedulerfunctions.printNotificationMessage(constants.notificationMsg.Error,constants.message.systemError,constants.notificationMsg.error);
		}
	});
	return responseObj;
}

schedulerfunctions.ajaxServerRequestResponseWithoutJsonObj = function(url) {
	var responseObj = null;
	$.ajax({
		url : url,
		method: constants.ajaxParameter.postmethod,
		async : constants.ajaxParameter.asynchfalse,
		type : constants.ajaxParameter.type,
		contentType : constants.ajaxParameter.contentType,
		success : function(response) {
			responseObj = response;
		},
		error : function() {
			schedulerfunctions.printNotificationMessage(constants.notificationMsg.Error,constants.message.systemError,constants.notificationMsg.error);
		}
	});
	return responseObj;
}

schedulerfunctions.printSuccessErrorMessage = function(response) {
	$.each(response.dataMap,function(key,value) {
		if(constants.notificationMsg.success === key) {
			schedulerfunctions.printNotificationMessage(value,constants.notificationMsg.success);
		} else {
			schedulerfunctions.printNotificationMessage(value,constants.notificationMsg.error);
		}
	});
};

schedulerfunctions.printNotificationMessage = function(message,type) {
	$('#messageId').text('');
	$('#messageId').text(message);
	$("#messageId").attr('class', '');
	$('#messageId').addClass(type);
};

schedulerfunctions.getJsonObj = function(form) {
	var jsonObj = {};
	$(form).find('input , select').each(function() {
		if(invtmgmtsysutil.isNotBlank($(this).attr('name'))) {
			jsonObj[$(this).attr('name')] = $(this).val().toString();
		}
	});
	return jsonObj;
};

$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};