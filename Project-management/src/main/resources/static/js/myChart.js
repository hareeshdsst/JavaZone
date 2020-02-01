var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);
var arrayLength = chartJsonArray.length;
var numericData = [];
var labelData = [];

for(var i=0;i < arrayLength; i++){
	numericData[i] = chartJsonArray[i].value;
	labelData[i] = chartJsonArray[i].label;
}
// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
 // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#3e95cd","#8e5ea2","#3cba9f"],
            borderColor: 'rgb(255, 99, 132)',
            data: numericData
        }]
    },
    
    options: {
    	title: {
    		display :true,
    		text : 'Project Statues'
    	}
    }
});

// [{"value": 1, "label": "COMPLETED" },{"value": 1, "label": "INPROGRESS"
// },{"value": 1, "label": "NOTCOMPLETED" }]
function decodeHtml(html){
	var txt = document.createElement("textarea");
	txt.innerHTML = html;
	return txt.value;
}