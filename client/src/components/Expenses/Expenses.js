import React, { useState } from "react";
import Card from "src/components/UI/Card";
import ExpensesFilter from "./ExpensesFilter";
import ExpensesList from "./ExpensesList";
import ExpensesChart from "./ExpensesChart";
import "./Expenses.css";

const Expenses = (props) => {
  const [year, setYear] = useState("2022");
  const handleYearSelection = (selectedYear) => {
    setYear(selectedYear);
  };

  const handleDelete = (expense) => {
    props.onDelete(expense);
  }

  const filteredExpenses = props.items.filter(
    (item) => item.date.getFullYear() === Number(year)
  );

  return (
    <Card className="expenses">
      <ExpensesFilter year={year} onYearSelection={handleYearSelection} />
      <ExpensesChart expenses={filteredExpenses} />
      <ExpensesList items={filteredExpenses} onDelete={handleDelete}/>
    </Card>
  );
};

export default Expenses;
