<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false" %>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '注册走势'
        },
        tooltip: {},
        legend: {
            data: ['注册量']
        },
        xAxis: {
            data: ["今天", "前1天", "前2天", "前3天", "前4天", "前5天", "前6天"]
        },
        yAxis: {},
        series: [{
            name: '注册量',
            type: 'line'
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    $.ajax({
        url: "${pageContext.request.contextPath}/echarts/query",
        datatype: "json",
        type: "POST",
        success: function (da) {
            myChart.setOption({
                series: [{data: da}]
            });
        }
    });


</script>

