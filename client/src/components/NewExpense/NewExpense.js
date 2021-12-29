import React, { useState } from "react";

import ExpenseForm from './ExpenseForm';
import './NewExpense.css';

const NewExpense = (props) => {
  const handleExpenseSaveData = (oSavedExpenseData) => {
    const oExpenseData = {
      ...oSavedExpenseData,
    };
    props.onAddExpense(oExpenseData);
    setEditMode((prev) => !prev);
  };
  
  const [editMode, setEditMode] = useState(false);
  const handleAddNewExpense = () => {
    setEditMode((prev) => !prev);
  }
  const handleExpenseFormCancel = () => {
    setEditMode((prev) => !prev);
  }

  let content = <button onClick={handleAddNewExpense}>Aggiungi una nuova spesa</button>;
  if(editMode) {
    content = <ExpenseForm onSaveExpenseData={handleExpenseSaveData} onCancel={handleExpenseFormCancel}/>;
  }
  return (
    <div className="new-expense">
      {content}
    </div>
  );
};

export default NewExpense;
