//チャート用データ
var dataPlot = [
  { label: "リンゴ",   y: 10 },
  { label: "オレンジ", y: 15 },
  { label: "バナナ",   y: 25 },
  { label: "マンゴー", y: 30 },
  { label: "グレープ", y: 28 }
];
//========================================

//チャートの生成
var chart = new CanvasJS.Chart("chartContainer", {
  data: [{
    type: 'line',
    dataPoints: dataPlot
  }]
});
chart.render();
