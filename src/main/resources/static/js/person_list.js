let SERVER_IP = "http://127.0.0.1/";

let personListUrl = "/person/list";
let personDetailUrl = "/person/detail/get";

$().ready(function () {
    getPersonList();
});

function getPersonList() {
    let picAreaHtml = "";
    let personList = _get(personListUrl);
    personList.forEach(person => {
        picAreaHtml += buildPicHtml(person.id, person.name, person.photo);
    });
    $("#pic-area").html(picAreaHtml);
}

function buildPicHtml(id, name, photoAddress) {
    if (ifEmpty(photoAddress)) {
        photoAddress = "../pic/head.jpg";
    } else {
        photoAddress = SERVER_IP + photoAddress;
    }
    return "<div class=\"pic\" id=\"" + id + "\" onclick=\"selectPersonInfo(this)\" onmouseover=\"mouseOver(this)\" onmouseout=\"mouseOut(this)\">" +
        "            <img class=\"img-url\" draggable=\"false\" alt=\"暂无图片\" src=\"" + photoAddress + "\">" +
        "            <div class=\"img-infos\">" +
        "                <div class=\"img-info\">" +
        "                    <div class=\"value\"><label>" + name + "</label></div>\n" +
        "                </div>" +
        "            </div>" +
        "        </div>";
}

function selectPersonInfo(_this) {
    let personDetail = _get(personDetailUrl + "?personId=" + _this.id);
    alert("个人信息详情\n\n" + JSON.stringify(personDetail));
}

function ifEmpty(value) {
    return value == null || value === "";
}