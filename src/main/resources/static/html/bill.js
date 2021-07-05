$().ready(function () {
    let list_url = "/pmp/bill/list";
    let save_url = "/pmp/bill/save";
    showList(_get(list_url));
    $("#submit").click(function () {
        let type = $("#type option:selected").val();
        let consumer = $("#consumer option:selected").val();
        let total = $("#total").val();
        let remark = $("#remark").val();
        if (total == null || total === "") {
            alert("请输入总数");
            return;
        }
        if (type === "2") {
            total = -total;
        }
        let data = {
            "consumer": consumer,
            "total" : total,
            "remark" : remark
        };
        _post(save_url, JSON.stringify(data));
        showList(_get(list_url));
    });
});

function showList(result) {
    let data = "<table><tr><td>第几个</td><td>啥样嘞</td><td>弄多少</td><td>谁弄嘞</td><td>弄啥嘞</td><td>啥时候</td></tr>";
    for (let i = 0; i < result.length; i++) {
        let element = result[i];
        let total = element.total;
        let consumer = element.consumer;
        let remark = element.remark;
        let consumeTime = element.consumeTime;
        let type = "收入";
        if (total < 0) {
            type = "支出";
            total = -total;
        }
        if (consumer === "1") {
            consumer = "wyhw";
        } else if (consumer === "2") {
            consumer = "lml";
        } else {
            consumer = "both";
        }
        data += "<tr><td>" + (result.length - i) + "</td><td>" + type + "</td><td>" + total + "</td><td>" + consumer + "</td><td>" + remark+ "</td><td>" + consumeTime + "</td></tr>";
    }
    data += "</table>";
    $(".bill-list-content").html(data);
}
