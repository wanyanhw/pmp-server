let socket;
function ServerWebsocket() {
    this.init = function(cid) {
        let ws_url = "ws://localhost:8080/pmp/websocket/" + cid;
        socket = new WebSocket(ws_url);
        return socket;
    };
    this.send = function(msg) {
        socket.send(msg);
    }
}