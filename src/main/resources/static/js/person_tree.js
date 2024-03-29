let getPersonTreeUrl = "/person/tree/list";
$().ready(function () {
    loadTrees();
});

function loadTrees() {
    let myChart = echarts.init(document.getElementById('tree-area'));
    myChart.showLoading();
    let trees = _get(getPersonTreeUrl + "?parentId=0");

    let treeSize = trees.length;
    let data = [];
    for (let i = 0; i < treeSize; i++) {
        let tree = trees[i];
        data[i] = {
            type: 'tree',
            name: '人物关系图' + i,
            data: [tree],
            top: '0%',
            left: '10%',
            symbol: 'emptyCircle',
            symbolSize: 25,
            layout: 'orthogonal',
            height: '100%',
            // 折线
            // edgeShape: 'polyline',
            // edgeForkPosition: '100%',
            orient: 'LR',
            label: {
                fontSize: 15,
                position: 'right'
            },
            lineStyle: {
                width: 0.5,
                color: '#F00'
            },
            leaves: {
                label: {
                    position: 'right'
                }
            },
            emphasis: {
                focus: 'none'
            },
            expandAndCollapse: true,
            animationDuration: 550,
            animationDurationUpdate: 750,
            initialTreeDepth: -1
        };
    }

    console.log(data);
    myChart.hideLoading();
    let option = {
        tooltip: {
            trigger: 'item',
            triggerOn: 'mousemove',
            valueFormatter: (value) => '&' + value.toFixed(2)
        },
        series: data
    };
    myChart.setOption(option);
}