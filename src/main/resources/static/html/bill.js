let timer;
$().ready(function () {
    let list_url = "/pmp/bill/list";
    let save_url = "/pmp/bill/save";
    scroll_show();
    // showList(_get(list_url));
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
        // _post(save_url, JSON.stringify(data));
        // showList(_get(list_url));
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

function scroll_show() {
    timer = setInterval(function () {
        moveLeft(0.5);
    }, 1);
}

let labelFormerWidth;
function moveLeft(speed) {
    let scrollShowWidth = $(".scroll-show").css("width");
    let scrollShowWidthPx = scrollShowWidth.substr(0, scrollShowWidth.length - 2);
    let $scroll = $(".scroll-show > label");
    if (labelFormerWidth == null) {
        labelFormerWidth = $scroll.css("width");
    }
    let labelWidth = $scroll.css("width");
    let labelWidthPx = labelWidth.substr(0, labelWidth.length - 2);
    let marginLeft = $scroll.css("marginLeft");
    let marginLeftPx = marginLeft.substr(0, marginLeft.length - 2);
    if (marginLeftPx <= 0) {
        if (parseInt(labelWidthPx) + parseInt(marginLeftPx) <= 0) {
            marginLeftPx = scrollShowWidthPx;
        }
    }
    $scroll.css("marginLeft", (marginLeftPx - speed));
}

function hover() {
    clearInterval(timer);
}
