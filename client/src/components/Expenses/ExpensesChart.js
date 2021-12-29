import React from "react";

import Chart from "src/components/Chart/Chart.js"

const ExpensesChart = props => {
    const chartDataPoints = [
        {value: 0, label: "Gen"},
        {value: 0, label: "Feb"},
        {value: 0, label: "Mar"},
        {value: 0, label: "Apr"},
        {value: 0, label: "Mag"},
        {value: 0, label: "Giu"},
        {value: 0, label: "Lug"},
        {value: 0, label: "Ago"},
        {value: 0, label: "Set"},
        {value: 0, label: "Ott"},
        {value: 0, label: "Nov"},
        {value: 0, label: "Dic"}
    ];
    props.expenses.forEach(expense => {
        const expenseMonth = expense.date.getMonth(); // Gen è 0, dic 11
        chartDataPoints[expenseMonth].value += expense.amount;
    });

    return <Chart dataPoints={chartDataPoints} />
};

export default ExpensesChart;