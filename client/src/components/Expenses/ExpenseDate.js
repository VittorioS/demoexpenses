import React from "react";

import "./ExpenseDate.css";

const ExpenseDate = (props) => {
  const sMonth = props.date.toLocaleString('it-IT', {month: "long"});
  const sDay = props.date.toLocaleString('it-IT', {day: "2-digit"});
  const sYear = props.date.getFullYear();

  return (
  <div className="expense-date">
    <div className="expense-date__month">{sMonth}</div>
    <div className="expense-date__year">{sDay}</div>
    <div className="expense-date__day">{sYear}</div>
  </div>
  );
}

export default ExpenseDate;
