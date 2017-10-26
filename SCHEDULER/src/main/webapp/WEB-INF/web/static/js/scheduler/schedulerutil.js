var schedulerutil = {};

schedulerutil.isBlank = function(input) {
	return (undefined === input || null === input || '' == input.trim());
}

schedulerutil.isNotBlank = function(input) {
	return (undefined !== input && null !== input && '' !== input.trim());
}

schedulerutil.isNullOrUndefined = function(input) {
	return (undefined === input || null === input);
}