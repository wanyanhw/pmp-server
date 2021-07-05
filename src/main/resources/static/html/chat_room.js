let server_url = "localhost:8080";
let socket = null;
$().ready(function () {
   let ws_url = "ws://" + server_url + "/pmp/websocket/c1";
   socket = new WebSocket(ws_url);
   socket.onopen = function () {
       console.log("连接成功");
   };
   socket.onclose = function (e) {
       console.log("断开连接", e.code);
   };
   socket.onerror = function (e) {
       console.log("连接失败", e);
   };
   socket.onmessage = function (e) {
       showContent(e.data);
   }
});

function send() {
    let $content = $("#content");
    let content_val = $content.val();
    socket.send(content_val);
    $content.val(null);
}

function showContent(msg) {
    let $console = $("#console");
    let console_val = $console.html();
    console_val += "<br/>" + msg;
    $console.html(console_val);
}