import React, { useState } from "react"

// import ExpenseForm from './ExpenseForm';
import ExpenseFormFullscreen from "./ExpenseFormFullscreen"
import "./NewExpense.css"

const NewExpense = (props) => {
  const handleExpenseSaveData = (oSavedExpenseData) => {
    const oExpenseData = {
      ...oSavedExpenseData,
    }
    props.onAddExpense(oExpenseData)
    props.onEdit(false)
    setEditMode(false)
  }

  const [editMode, setEditMode] = useState(false)
  const handleAddNewExpense = () => {
    props.onEdit(true)
    setEditMode(true)
  }
  const handleExpenseFormCancel = () => {
    props.onEdit(false)
    setEditMode(false)
  }

  let content = (
    <button onClick={handleAddNewExpense}>Aggiungi una nuova spesa</button>
  )
  if (editMode) {
    content = (
      <ExpenseFormFullscreen
        onSaveExpenseData={handleExpenseSaveData}
        onCancel={handleExpenseFormCancel}
      />
    )
  }
  return <div className="new-expense">{content}</div>
}

export default NewExpense
