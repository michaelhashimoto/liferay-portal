function getFirstImageURL() {
	var images = document.images;

	for (var i = 0; i < images.length; i++) {
		var url = images[i].src;

		if (url.startsWith("http")) {
			return url;
		}
	}

	return;
}

function updateAuthUser(url, authuser) {
	var regExp = new RegExp("authuser=[^&]+");

	if (url.match(regExp)) {
		url = url.replace(regExp, "authuser=" + authuser);
	}
	else if (url.includes("?")) {
		url += "&authuser=" + authuser;
	}
	else {
		url += "?authuser=" + authuser;
	}

	console.log("A " + url);

	return url;
}

function updateImages() {
	var firstImageURL = getFirstImageURL();

	if (firstImageURL == null) {
		return;
	}

	for (var i = 0; i < 5; i++) {
		var image = new Image();

		image.authuser = i;

		image.onload = function() {
			if (this.width <= 0) {
				return;
			}

			var images = document.images;

			for (var i = 0; i < images.length; i++) {
				var url = images[i].src;

				if (!url.startsWith("http")) {
					continue;
				}

				console.log("0 " + images[i]);
				console.log("1 " + this.authuser);
				console.log("2 " + this);
				console.log("3 " + url);
				console.log("4 " + images[i].src);

				images[i].src = updateAuthUser(url, this.authuser);

				console.log("5 " + images[i].src);
			}
		}

		console.log("i=" + i);
		console.log("firstImageURL=" + firstImageURL);
		console.log("image.src=" + image.src);

		image.src = updateAuthUser(firstImageURL, i);

		console.log("image.src=" + image.src);
	}
}

updateImages();