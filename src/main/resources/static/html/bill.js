let timer;
$().ready(function () {
    let list_url = "/bill/list";
    let save_url = "/bill/save";
    let billEleList = _get(list_url);
    // initScrollShow(billEleList);
    // let $scroll_show_labels = $(".scroll-show label");
    // let labelNum = $scroll_show_labels.length;
    // timer = new Array(labelNum);
    // for (let i = 0; i < labelNum; i++) {
    //     scroll_show(i);
    // }
    showList(billEleList);
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

/**
 * 初始化弹幕区域
 * @param resultList
 */
function initScrollShow(resultList) {
    for (let i = 0; i < resultList.length; i++) {
        let result = resultList[i];
        let total = result.total;
        let consumer = result.consumer;
        let remark = result.remark;
        let consumeTime = result.consumeTime;
        let content = consumer + "在" + consumeTime + (total > 0 ? "收入了" : "支出了") + total + "元在" + remark + "上";
        $(".scroll-show").append("<label onmouseover=\"hover(" + i + ")\" onmouseout=\"scroll_show(" + i + ")\">" + content + "</label><br><br>")
    }
}

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

function scroll_show(index) {
    let $label = $(".scroll-show label").eq(index);
    timer[index] = setInterval(function () {
        moveLeft($label, 0.5);
    }, 1);
}

let labelFormerWidth;
function moveLeft($scroll, speed) {
    let scrollShowWidth = $(".scroll-show").css("width");
    let scrollShowWidthPx = scrollShowWidth.substr(0, scrollShowWidth.length - 2);
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

function hover(index) {
    clearInterval(timer[index]);
}
