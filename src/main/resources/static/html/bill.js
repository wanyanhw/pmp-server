$().ready(function () {
    $("#submit").click(function () {
        let type = $("#type option:selected").val();
        let total = $("#total").val();
        let remark = $("#remark").val();
        if (type === "2") {
            total = -total;
        }
        let data = {
            "total" : total,
            "remark" : remark
        };
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/pmp/bill/save",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                if (result != null && result) {
                    alert("已完成");
                }
            }
        });
    });
});
