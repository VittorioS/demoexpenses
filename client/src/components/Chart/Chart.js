import React from "react";

import ChartBar from "./ChartBar";
import "./Chart.css";

const Chart = props => {
    const values = props.dataPoints.map(item => item.value);
    const maxValue = Math.max(...values);
  
    return (
    <div className="chart">
      {props.dataPoints.map((dataPoint) => (
        <ChartBar
          key={dataPoint.label}
          value={dataPoint.value}
          maxValue={maxValue}
          label={dataPoint.label}
        />
      ))}
    </div>
  );
};

export default Chart;
