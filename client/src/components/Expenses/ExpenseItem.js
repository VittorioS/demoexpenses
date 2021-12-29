import React from "react";

import ExpenseDate from "./ExpenseDate";
import Card from "src/components/UI/Card";
import "./ExpenseItem.css";

const ExpenseItem = (props) => {
  return (
    <li>
      <Card className="expense-item">
        <ExpenseDate date={props.date} />
        <div className="expense-item__description">
          <h2>{props.title}</h2>
          <div className="expense-item__price">€{props.amount}</div>
          <button className="expense-item__delete" onClick={props.onDeleteItem}><img src="https://img.icons8.com/material-rounded/30/FFFFFF/filled-trash.png"/></button>
        </div>
      </Card>
    </li>
  );
};

export default ExpenseItem;
