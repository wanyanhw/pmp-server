let PROTOCOL = "http";
let SERVER = "localhost";
let PORT = 8080;
let SERVER_URL = PROTOCOL + "://" + SERVER + ":" + PORT;
function _post(url, data) {
    let res = null;
    $.ajax({
        type: "POST",
        url: SERVER_URL + validateUrl(url),
        data: data,
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (result) {
            res = result;
        }
    });
    return res;
}

function _get(url) {
    let res = null;
    $.ajax({
        type: "GET",
        url: SERVER_URL + validateUrl(url),
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (result) {
            res = result;
        }
    });
    return res;
}

function validateUrl(url) {
    if (!url.startsWith('/')) {
        url = "/" + url;
    }
    return url;
}