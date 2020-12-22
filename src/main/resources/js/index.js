var width = 800,
    height = 800;
//定义数据转换函数
var tree = d3.layout.tree()
    .size([width, height - 200]);

//定义对角线生成器diagonal
var diagonal = d3.svg.diagonal()
    .projection(function(d){ return [d.y, d.x] });

//定义svg
var svg = d3.select("body").append("svg")
    .attr("width",width)
    .attr("height",height)
    .append("g")
    .attr("transform","translate(40, 0)");

//读取json文件，进行绘图
var jsonData = "cData.json";
d3.json(jsonData, function (value) {
    console.log("data:", value);
    var nodes = tree.nodes(value);
    var links = tree.links(nodes);

    //画点
    var node = svg.selectAll(".node")
        .data(nodes)
        .enter()
        .append("g")
        .attr("class","node")
        .attr("transform", function(d){ return "translate(" + d.y + "," + d.x + ")" });
    //加圈圈
    node.append("circle")
        .attr("r",10);
    //加文字
    node.append("text")
        .attr("dy",5)
        .attr("dx",function(d){ return d.children ? -20 : 20; })
        .style("text-anchor", function (d) { return d.children ? "end" : "start" })
        .text(function (d) { return d.name });

    //画线
    var line = svg.selectAll("link")
        .data(links)
        .enter()
        .append("path")
        .attr("class","link")
        .attr("d",diagonal);
});
