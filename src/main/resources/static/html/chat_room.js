let webSocket;
let serverWebsocket;
$().ready(function () {
    serverWebsocket = new ServerWebsocket();
});

function connect(cid) {
    webSocket = serverWebsocket.init(cid);
    webSocket.onopen = function () {
        console.log("ws connect success")
    };
    webSocket.onmessage = function (ev) {
        showContent(ev.data);
    };
    webSocket.onclose = function () {
        console.log("ws disconnect success");
    };
}

function disconnect() {
    webSocket.close();
}

function send() {
    let $input = $("#input-content");
    let content_val = $input.val();
    webSocket.send(content_val);
    $input.val(null);
}

function showContent(msg) {
    let $console = $("#console");
    let console_val = $console.html();
    console_val += "<br/>" + msg;
    $console.html(console_val);
}